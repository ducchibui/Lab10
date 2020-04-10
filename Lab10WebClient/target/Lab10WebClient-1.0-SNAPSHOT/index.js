var app = new Vue({
    el:'#app',
    data: {
      books: null  
    },
    
    mounted: function () {
        fetch('http://localhost:8082/books')
            .then(response => response.json())
            .then(data => {
                this.books = data;
            })
    }
})
