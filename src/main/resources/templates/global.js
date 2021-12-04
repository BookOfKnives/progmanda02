console.log("out")

function createNavBarFunction() {

    const navBarDiv = document.getElementById("navBarDiv");
    const createNavBar = `<div>
<a href="./index.html">
    <img id="logo" src="./myfirstlogo.png" alt="logo art">
</a>
<a href="../matches/matches.html">Matches</a>
</div>`;

    navBarDiv.innerHTML = createNavBar;
}

createNavBarFunction();
