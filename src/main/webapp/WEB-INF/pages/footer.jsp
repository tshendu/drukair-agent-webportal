<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<footer style="background: #1e306d; color: #ffffff; font-size: 12px; text-align: center; padding: 30px; margin-top: 20px">
    <div class="container custom-footer">
        <p>
            Copyright &copy; Drukair Corporation Limited,
            <%
                String currentDate = new SimpleDateFormat("yyyy").format(new Date());
                out.print(currentDate);
            %>
            | All rights reserved.
        </p>
    </div>
</footer>