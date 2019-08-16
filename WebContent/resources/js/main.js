// Applying Bootstrap 4 Data Table to Show All the Footballers
$(document).ready(function() {	
    $('#players-table').DataTable({
        "order": [[1, "asc"]]
    });
});