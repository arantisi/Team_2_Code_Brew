console.log("my reviews page");
let moviesList;
let moviesItemTemplate;

// Function to search for a movie title and populate html
function searchForWatchlist(){
    console.log("test1");
    fetch(`/review/user`)
        .then((resp)=>{resp = resp.json()})
        .then(obj=>{
            for (let review of obj) { //go through the list of reviews for user, this doesn't get the poster though, nor movie title atm
                console.log(review)
                let a = reviewTemplate.cloneNode(true);
                //a.setAttribute("imdbId", mov.imdbID);
                //a.querySelector("#movieName").textContent = mov.Title+", "+mov.year;
                //a.querySelector("#icon").setAttribute("src", mov.poster);
                a.querySelector("#review").textContent = review.review + ", " + review.rating;
                moviesList.appendChild(a);
            }
        })
        .catch(err=>console.log("error encountered while fetching title " + err));
}

// Clear movies list
function clearMoviesList() {
    while (moviesList.firstChild)
        moviesList.firstChild.remove();
}

// On DOM loaded
document.addEventListener('DOMContentLoaded', () => {
    // set up some stuff
    console.log("test");
    moviesList = document.querySelector(".movie-search-list")
    let a = document.querySelector(".movie-search-item")
    moviesItemTemplate = a.cloneNode(true);
    a.remove();

    // attach click event to search button
    document.querySelector("#button-movie-search").onclick = ((evt)=>{
        evt.preventDefault();
        clearMoviesList();

        let searchStr = document.querySelector("#input-movie-search").value.toLowerCase();
        if (searchStr !== "")
            searchForTitle(searchStr);
    })
})