<%@ include file="/WEB-INF/jspf/settings.jspf" %>
<html>
<head>
    <title><fmt:message key='user.orderdetails'/></title>
    <%@ include file="/WEB-INF/jspf/stylesheets.jspf" %>
    <link rel="stylesheet" href="<c:url value="/content/css/order.css"/>">
</head>
<body>
    <div class="container">
        <h1>Welcome to Bargain Page</h1>
        <p>This is where you can initiate bargaining for your order.</p>
        <form id="bargainForm" action="<c:url value='/InitiateBargainingServlet'/>" method="post">
            <label for="orderId">Order ID:</label>
            <input type="text" id="orderId" name="orderId" required><br><br>
            <label for="proposedFare">Proposed Fare:</label>
            <input type="text" id="proposedFare" name="proposedFare" required><br><br>
            <button type="submit">Initiate Bargaining</button>
        </form>
        <div id="message"></div>
    </div>

    <script>
        $(document).ready(function() {
            $('#bargainForm').submit(function(event) {
                event.preventDefault();
                var orderId = $('#orderId').val();
                var proposedFare = $('#proposedFare').val();
                $.ajax({
                    type: 'POST',
                    url: '<c:url value="/InitiateBargainingServlet"/>',
                    data: {
                        orderId: orderId,
                        proposedFare: proposedFare
                    },
                    success: function(response) {
                        $('#message').html(response);
                    },
                    error: function(xhr, status, error) {
                        $('#message').html('Failed to initiate bargaining');
                    }
                });
            });
        });
    </script>
</body>
</html>
