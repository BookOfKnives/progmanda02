
const matchesNavWrapper = document.getElementById("HtmlDivForNav");

const createNavBar = `<div>
    <label>Name</label>
    <input id="create-gallery-name" placeholder="name">
    <label>Location</label>
    <input id="create-gallery-location" placeholder="location">    
    <label>Owner</label>
    <input id="create-gallery-owner" placeholder="owner">    
    <label>Square Feet</label>
    <input id="create-gallery-square-feet" placeholder="square feet">
    <button onclick="removeGalleryForm()">Cancel</button>
    <button onclick="createGallery()">Create A New Gallery</button>
</div>`;

function createArtistCard() {
   const artistElement = document.createElement("div");
    //artistElement.innerText = createNavBar;
    artistElement.innerHTML = createNavBar;

    matchesNavWrapper.appendChild(artistElement);
}


document.getElementById("create-artist-button")
    .addEventListener("click", createArtistCard);

