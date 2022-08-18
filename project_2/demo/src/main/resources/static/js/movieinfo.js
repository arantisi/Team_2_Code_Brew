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

    let userRating = 0;
    // Review rating stars click
    document.querySelectorAll(".rating-star").forEach((n)=>{
        n.onclick = () => userRating = n.getAttribute('value');
    });

    // Review button on click
    document.querySelector("#review-btn").onclick = (evt)=>{
        if (userRating < 1) {
            console.log("Select user rating");
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
            body: JSON.stringify(data)
        }).then(()=>{
            console.log("sentPOST");
        }).catch((err) => {
            console.log("Failed to POST data");
        })

        // double checking.. sending to get
        fetch("/review/user")
            .then((resp)=>{
                resp=resp.json();
            })
            .then(obj=>{
                console.log("GET success user reviews obj");
                console.log(obj); // This obj is undefined, which means the server never sent it
            })
            .catch((err) => {
                console.log("Failed to GET data");
                console.log(err);
            })
    }

    // Favorites button on click
    document.querySelector("#favorites-btn").onclick = (evt)=>{
        console.log("add to favorites " + id);
    }

    // Watchlist button on click
    document.querySelector("#watchlist-btn").onclick = (evt)=>{
        console.log("add to watchlist " + id);
    }

    searchForTitle(id);
})