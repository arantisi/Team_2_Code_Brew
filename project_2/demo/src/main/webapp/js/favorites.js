
let moviesList;
let posterTemplate;
function searchForWatchlist(){
    console.log("test1");
    fetch(`/favorite/user`)
        .then((resp)=>{resp = resp.json()})
        .then(obj=>{
            for (let favItem of obj) { //go through the list of movies
                console.log(favItem)
                fetch(`/omdb/searchId/${favItem.movieId}`)
                .then((resp)=> resp = resp.json())
                .then(mov=>{
                    console.log(mov);
                    let a = posterTemplate.cloneNode(true);
                    a.setAttribute("imdbId", mov.imdbID);
                    a.querySelector("#movieName").textContent = mov.Title+", "+mov.year;
                    a.querySelector("#icon").setAttribute("src", mov.poster);
                    moviesList.appendChild(a);
                })
            }
        })
        .catch(err=>console.log("error encountered while fetching title " + err));
}
//dom LOADED
document.addEventListener('DOMContentLoaded', () => {
    // set up some stuff
    console.log("DOM loaded");
    moviesList = document.querySelector(".watchlist")
    let a = document.querySelector(".poster")
    moviesItemTemplate = a.cloneNode(true);
    a.remove();
    console.log(moviesList);
    searchForWatchlist();
})
