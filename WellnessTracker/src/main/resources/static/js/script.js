window.addEventListener('load', function(e){
	console.log('script.js loaded');
	getAllWellness();
	init();
});
function getAllWellness(){
	console.log('get All Wellness');
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/wellness/');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let wellJson = xhr.responseText;
				let wellness = JSON.parse(wellJson);
				console.log(wellness);
				loadWellness(wellness);
				
			}
			else {
				
			}
		}
		
		
	}
	xhr.send();
}
function getWellness(wellnessId) {
	console.log(wellnessId);

	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/wellness/${wellnessId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let wellJson = xhr.responseText;
				let wellness = JSON.parse(wellJson);
				console.log(wellness);
				displayWellness(wellness);

			}
			else {
				
			}
		}
		
		
	}
	
	
	xhr.send();
}

function postNewWellness(newWellness) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/wellness');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let wellness = JSON.parse(xhr.responseText);
				displayWellness(wellness);
			}
		}
		else {

		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newWellness));
}

function init(){
	console.log('In init()');
	// document.wellForm.getWellness.addEventListener('click', function(event) {
	// 	event.preventDefault();
	// 	var wellnessId = document.wellForm.wellnessId.value;
	// 	if (!isNaN(wellnessId) && wellnessId > 0) {
	// 		getWellness(wellnessId);
	// 	}
	
	document.addWellForm.postNewWellness.addEventListener('click', function(event) {
		event.preventDefault();
		let fm = document.addWellForm;
		let newWellness= {
			activity: fm.activity.value,
			minutes: fm.minutes.value,
			moodBefore: fm.moodBefore.value,
			moodAfter: fm.moodAfter.value,
			date: fm.date.value,
			notes: fm.notes.value
		};
		console.log(newWellness);
		postNewWellness(newWellness);
	});
}
function displayWellness(wellness) {
	var dataDiv = document.getElementById('wellData');
	dataDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = wellness.activity;
	dataDiv.appendChild(h1);
	let ul = document.createElement('ul');
	dataDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = wellness.minutes;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = wellness.moodBefore;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = wellness.moodAfter;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = wellness.date;
	ul.appendChild(li);
	let bq = document.createElement('blockquote');
	bq.textContent = wellness.notes;
	dataDiv.appendChild(bq);


	// TODO:
	// * Create and append elements to the data div to display:
	// * Film title (h1) and description (blockquote).
	// * Rating, release year, and length as an unordered list.
}

function loadWellness(wellness){
	
	let table = document.createElement('table');
	document.body.appendChild(table);
	let head = document.createElement('thead');
	table.appendChild(head);
	let t = document.createElement('th');
	t.textContent = 'Id';
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Activity',
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Minutes',
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Notes',
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Mood Before',
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Mood After',
	head.appendChild(t);
	t= document.createElement('th');
	t.textContent ='Date',
	head.appendChild(t);
	let tbod = document.createElement('tbody');
	table.appendChild(tbod);
	for ( well of wellness) {
		
		let tr = document.createElement('tr');

		
		
		
		let td = document.createElement('td');
		td.textContent = well.id;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.activity;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.minutes;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.notes;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.moodBefore;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.moodAfter;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = well.date;
		tr.appendChild(td);
		tbod.appendChild(tr);
		let editButton = document.createElement('input');
		editButton.setAttribute('type', 'button');
		editButton.setAttribute('value','Edit');
		editButton.addEventListener('onclick', function(event){
			event.preventDefault();

			editWellness(well.id);

		});
		tr.appendChild(editButton);
		
		let deleteButton = document.createElement('input');
		deleteButton.setAttribute('type', 'button');
		deleteButton.setAttribute('value','Delete');
		deleteButton.addEventListener('click', function(event) {
		event.preventDefault();
		deleteWellness(well.id);

		});
		tr.appendChild(deleteButton);
		
		
		
		
		
		// displayWellness(wellness);
		tr.addEventListener('click', function(event){
			var id = this.rowIndex + 1;
			getWellness(id);
		});
	
	}
	function editWellness(wellnessId){
		
		
		let xhr = new XMLHttpRequest();
		xhr.open('PUT', `api/wellness/${wellnessId}`);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200 || xhr.status === 201) {
					let wellJson = xhr.responseText;
					let wellness = JSON.parse(wellJson);
					console.log(wellness);
					displayWellness(wellness);
				}
			}
			else {
				
			}
		};
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(JSON.stringify(newWellness));
	}

		function deleteWellness(wellnessId){

			let xhr = new XMLHttpRequest();
			xhr.open('DELETE', `api/wellness/${wellnessId}`);
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200 || xhr.status === 201) {
						let wellJson = xhr.responseText;
						let wellness = JSON.parse(wellJson);
						console.log(wellness);
						displayWellness(wellness);
						
						
					}
				}

			}
			xhr.setRequestHeader('Content-type', 'application/json');

			xhr.send(JSON.stringify(wellness));
	}
	
		
			

		
}		
		
	
	
	
	
	
	
	
