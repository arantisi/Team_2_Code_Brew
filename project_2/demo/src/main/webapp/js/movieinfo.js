let poster;
let title;
let desc;

// Function to search for a movieId
function searchForTitle(id) {
    let ret = {};
    fetch(`/omdb/searchId/${id}`)
        .then(resp=>resp = resp.json())
        .then(obj=>{
            console.log(obj);
            poster.setAttribute('src', obj.poster);
            title.innerHTML = obj.title;
            desc.innerHTML = obj.plot;
        })
        .catch(err=>console.log("error encountered while fetching title"));
    
    
}

// On DOM loaded
document.addEventListener('DOMContentLoaded', () => {
    //set up some stuff
    poster = document.querySelector("#moviePoster");
    title = document.querySelector("#movieTitle");
    desc = document.querySelector("#movieDesc");
    
    // from stackoverflow https://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    
        
    let movie = searchForTitle(id);
    
})