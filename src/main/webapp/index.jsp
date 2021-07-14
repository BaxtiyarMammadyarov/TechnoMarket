<%@ page import="java.io.PrintWriter" %>
<%@ page import="az.mycompany.TechnoMarket.model.Product" %>
<%@ page import="az.mycompany.TechnoMarket.db.ProductRepo" %>
<%@ page import="az.mycompany.TechnoMarket.util.Conversion" %>

<%@ page import="java.util.List" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Techno store</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div class="sayfa">
    <div class="baslik">
     <table style="width: 100%">
         <tr>
             <td></td>
             <td>Techno store</td>
             <td></td>
         </tr>
     </table>
    </div>
    <div class="menu">
        <ul>
            <li><a href="index.jsp" >Əsas səhifə</a></li>
            <li><a href="login.html">Profil</a></li>
            <li><a href="login.html">Giriş</a></li>
            <li><a href="registration.html" target="_blank">Qeydiyyat</a></li>
        </ul>

    </div>
    <div class="icerik">
        <div class="sol sutun">
            <h2>Butun məhsullar</h2>
            <div>
                <%
                    ProductRepo repo=new ProductRepo();
                    List<Product>list=repo.get();
                    List<String>productTypePhone=repo.getBrandNameByType("phone");
                    List<String>productTypeCom=repo.getBrandNameByType("komputer");
                    List<String>productTypeTv=repo.getBrandNameByType("tv");
                    List<String>productTypeClock=repo.getBrandNameByType("saat");
                    List<String>productTypePhotoVideo=repo.getBrandNameByType("foto");
                    List<String>productType=repo.getBrandNameByType("meiset");

                %>
                <details >
                    <summary> Telefonlar və Planşetlər </summary>
                    <%
                    for(String str:productTypePhone){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                     <%}%>
                </details>
            </div>
            <div>
                <details >
                    <summary>Kompüter və aksesuarları</summary>
                    <%
                        for(String str:productTypeCom){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                    <%}%>

                </details>
            </div>
            <div>
                <details>
                    <summary>Tv,audio video</summary>
                    <%
                        for(String str:productTypeTv){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                    <%}%>

                </details>
            </div>
            <div>
                <details>
                    <summary>Saatlar və qolbağilar</summary>
                    <%
                        for(String str:productTypeClock){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                    <%}%>

                </details>
            </div>
            <div>
                <details class="details">
                    <summary>Foto və video</summary>
                    <%
                        for(String str:productTypePhotoVideo){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                    <%}%>

                </details>
            </div>
            <div>
                <details>
                    <summary>Məişət texnikası</summary>
                    <%
                        for(String str:productType){
                    %>
                    <pg:item>
                        <h2><a href=""><%=str%></a></h2>
                    </pg:item>
                    <%}%>
                </details>
            </div>

        </div>
        <div class="orta sutun">
             <%

                 Conversion conversion=new Conversion();
                 for (Product product:list) {

             %>

            <pg:item>
                <li class="preorder"><span class="tagimg "></span> <a
                        href="">
                    <img src="<%=conversion.convertStringToImage(product.getPhoto())%>" width="100px" height="100px" />
                    <h3><%=product.getName()%></h3>
                    <h3><%=product.getColor()%></h3>
                    <h3><%=product.getModel().getName()%></h3>
                    <h3><%=product.getModel().getBrand().getName()%></h3>
                    <span class="textkm">ödəniləcək məbləğ <strong>500.000₫</strong>
								</span>
                    <p class="info">
                        <span>gjhgj</span>

                    </p>
                </a></li>
            </pg:item>
            <%
                }
            %>

        </div>
        <div class="sag sutun">
            <h2>Sağ</h2>
            <p>Lorem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir.</p>
        </div>
    </div>
    <div class="alt"><p>technostore.net</p></div>
</div>
</body>
</html>