window.onload = onLoadInit;

function onLoadInit() {
    document.getElementById("toEN").addEventListener("click",changeLanguage);
    document.getElementById("toFR").addEventListener("click",changeLanguage);
}

function changeLanguage(evt) {
    console.log(evt.target)
    switch(evt.target.getAttribute("id")) {
        case "toEN":
            postRequest("./united-kingdom/england/",{request_locale:"en"});
        break;
        case "toFR":
            postRequest("./united-kingdom/england/",{request_locale:"fr"});
        break;
    }
}