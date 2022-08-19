// Variables
let poster;
let title;
let desc;
let btnReview;
let btnFavorite;
let btnWatchlist;

// Function to search for a movieId
function searchForTitle(id) {
    fetch(`/omdb/searchId/${id}`)
        .then(resp=>resp = resp.json())
        .then(obj=>{
            //console.log(obj);
            poster.setAttribute('src', obj.poster);
            title.innerHTML = obj.title;
            desc.innerHTML = obj.plot;
        })
        .catch(err=>console.log("error encountered while fetching title"));
}

// Function to check watchlisted or not
async function checkForWatchlisted(id) {
    let ret = false;
    fetch(`/watchlist/user`)
        .then((resp)=>resp = resp.json())
        .then(obj=>{
            for (let watchItem of obj) {
                if (watchItem.movieId == id)
                    ret = true;
            }
        })
        .catch((err)=>console.log("Failed to pull user watchlist"));
    
    if (ret) {
        console.log("This movie is already watchlisted")
    }
}

// On DOM loaded
document.addEventListener('DOMContentLoaded', () => {
    // Setup variables
    poster = document.querySelector("#moviePoster");
    title = document.querySelector("#movieTitle");
    desc = document.querySelector("#movieDesc");
    btnReview = document.querySelector("#review-btn");
    btnFavorite = document.querySelector("#favorites-btn");
    btnWatchlist = document.querySelector("#watchlist-btn");
    
    // Pull movie ID from URL
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');

    // Check if user has watchlist favorited
    console.log("Pulling user watchlist..");
    checkForWatchlisted(id);

    let userRating = 0;
    // Review rating stars click event
    document.querySelectorAll(".rating-star").forEach((n)=>{
        n.onclick = () => userRating = n.getAttribute('value');
    });

    // Review button on click
    btnReview.onclick = (evt)=>{
        if (userRating < 1) {
            console.log("Must select user rating");
            return;
        }

        let userReview = document.querySelector("#message-text").value;
        console.log(userRating, userReview);

        // Build data to send
        let data = {
            review: userReview,
            rating: userRating
        }

        // Send POST request to endpoint
        fetch(`/review/create/${id}`, {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
              },
            }).then(()=>{
                
            }).catch((err) => {
                console.log("Failed to POST data");
            })
    }

    // Favorites button on click
    btnFavorite.onclick = (evt)=>{
        fetch(`/favorite/movie/${id}`, {
            method: "POST",
            }).then(()=>{
                console.log("Sent add to fav req")
            }).catch((err) => {
                console.log("Failed to POST data");
            })
    }

    // Watchlist button on click
    btnWatchlist.onclick = (evt)=>{
        fetch(`/watchlist/user/create/movie/${id}`, {
            method: "POST",
            }).then(()=>{
                console.log("Sent add to watchlist req")
            }).catch((err) => {
                console.log("Failed to POST data");
            })
    }

    searchForTitle(id);
})