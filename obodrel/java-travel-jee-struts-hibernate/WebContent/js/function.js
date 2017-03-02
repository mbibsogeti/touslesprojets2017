function postRequest(URL, paramArray) {
    var method = "post"; // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var tmpForm = document.createElement("form");
    tmpForm.setAttribute("method", method);
    tmpForm.setAttribute("action", URL);

    for(var key in paramArray) {
        if(paramArray.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", paramArray[key]);

            tmpForm.appendChild(hiddenField);
         }
    }

    document.body.appendChild(tmpForm);
    tmpForm.submit();
}