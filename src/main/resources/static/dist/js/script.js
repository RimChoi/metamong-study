function validateForm() {

    console.log('valid-form');

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelector('.needs-validation');

    /**
     * Array.prototype.filter() :
     * The filter() method creates a new array with all elements
     * that pass the test implemented by the provided function.
     *
     * Function.prototype.call()
     * The call() method calls a function with a given this value
     * and arguments provided individually.
     */

    // Loop over them and prevent submission
    Array.prototype.filter.call(forms, function (form) {
        form.addEventListener('submit', function (event) {
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated')
        }, false)
    })
}