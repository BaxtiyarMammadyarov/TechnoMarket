<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div class="sayfa">
    <div class="baslik">
     <table style="width: 100%">
         <tr>
             <td>td1</td>
             <td>Techno store</td>
             <td>td3</td>
         </tr>
     </table>
    </div>
    <div class="menu">
        <ul>
            <li><a href="index.jsp" >Əsas səhifə</a></li>
            <li><a href="#">Link2</a></li>
            <li><a href="#">Link3</a></li>
            <li><a href="#">Link4</a></li>
            <li><a href="registration.html" target="_blank">Qeydiyyat</a></li>
        </ul>

    </div>
    <div class="icerik">
        <div class="sol sutun">
            <h2>Butun məhsullar</h2>
            <div>
                <details >
                    <summary> Telefonlar və Planşetlər </summary>
                    <div><a href="phone" target="_blank">Samsung</a></div>
                    <div>Apple</div>
                    <div>Huawei</div>
                    <div>Lenovo</div>
                </details>
            </div>
            <div>
                <details >
                    <summary>Kompüter və aksesuarları</summary>
                    <div>div2</div>
                    <div>div2</div>
                    <div>div2</div>

                </details>
            </div>
            <div>
                <details>
                    <summary>Tv,audio video</summary>
                    <div>div2</div>
                    <div>div2</div>

                </details>
            </div>
            <div>
                <details>
                    <summary>Saatlar və qolbağilar</summary>
                    <div>div2</div>
                    <div>div2</div>
                    <div>div2</div>

                </details>
            </div>
            <div>
                <details class="details">
                    <summary>Foto və video</summary>
                    <div>div2</div>
                    <div>div2</div>
                    <div>div2</div>

                </details>
            </div>
            <div>
                <details>
                    <summary>Məişət texnikası</summary>
                    <div>div2</div>
                    <div>div2</div>
                    <div>div2</div>
                </details>
            </div>

        </div>
        <div class="orta sutun">
             <%
                 for (int i = 0; i < 10; i++) {

             %>

            <pg:item>
                <li class="preorder"><span class="tagimg "></span> <a
                        href="<%="pr"+i%>"> <img
                        src="" width="100px"
                        height="100px" />
                    <h3></h3>
                    <h4>

                    </h4> <span class="textkm">ödəniləcək məbləğ <strong>500.000₫</strong>
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