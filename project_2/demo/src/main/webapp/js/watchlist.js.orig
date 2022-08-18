
let moviesList;
let posterTemplate;
function searchForWatchlist(){
    console.log("test1");
    fetch(`/watchlist/public`)
        .then((resp)=>{console.log(resp); return resp.json()})
        .then(obj=>{
            for (let watchItem of obj) { //go through the list of movies
                console.log(watchItem)
                fetch(`/omdb/searchId/${watchItem.movieId}`)
                .then((resp)=> resp = resp.json())
                .then(mov=>{
                    console.log(mov);
                })
            }
        })
        .catch(err=>console.log("error encountered while fetching title " + err));
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
