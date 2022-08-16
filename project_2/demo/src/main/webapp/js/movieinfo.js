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
    
    // Review button on click
    document.querySelector("#review-btn").onclick = (evt)=>{
        let userReview = document.querySelector("#message-text").value;
        console.log(userReview);
    }

    // Favorites button on click
    document.querySelector("#favorites-btn").onclick = (evt)=>{
        console.log("add to favorites");
    }

    // Watchlist button on click
    document.querySelector("#watchlist-btn").onclick = (evt)=>{
        console.log("add to watchlist");
    }

    searchForTitle(id);

    
})