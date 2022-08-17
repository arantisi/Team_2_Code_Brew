
let moviesList;
let posterTemplate;
function searchForWatchlist(id){
    fetch(`/watchlist/${id}`)
        .then(resp=>resp = resp.json())
        .then(obj=>{
            console.log(obj);
            for (let movie of obj) { // populate table
                let a = posterTemplate.cloneNode(true);
                a.setAttribute("imdbId", movie.imdbID);
                a.querySelector("#movieName").textContent = movie.Title+", "+movie.year;
                a.querySelector("#icon").setAttribute("src", movie.poster);
                moviesList.appendChild(a);
            }
        })
        .catch(err=>console.log("error encountered while fetching title"));
}
//dom LOADED
document.addEventListener('DOMContentLoaded', () => {
    // set up some stuff
    console.log("DOM loaded");
    moviesList = document.querySelector("#watchlist")
    let a = document.querySelector(".poster")
    moviesItemTemplate = a.cloneNode(true);
    a.remove();
    console.log(moviesList);
    // from stackoverflow https://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    console.log(id);
    searchForWatchlist(id);
})
