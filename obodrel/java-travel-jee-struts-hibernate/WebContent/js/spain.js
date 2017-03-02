window.onload = onLoadInit;

function onLoadInit() {
    document.getElementById("specMonument").addEventListener("click",showMonument);
}

function showMonument(evt) {
    postRequest("./spain/byId",{"id":document.getElementById("monumentId").value});
}