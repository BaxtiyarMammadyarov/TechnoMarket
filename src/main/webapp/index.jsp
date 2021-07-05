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
            <li><a href="hello-servlet">Link1</a></li>
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
                    <div>div2</div>
                    <div>div2</div>
                </details>
            </div>
            <div>
                <details>
                    <summary>Tv,audio video</summary>
                    <div>div2</div>
                    <div>div2</div>
                    <div>div2</div>
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
                    <div>div2</div>
                    <div>div2</div>
                </details>
            </div>

        </div>
        <div class="orta sutun">

            <h2>Orta </h2>
            <p>Yaygın inancın tersine, Lorem Ipsum rastgele sözcüklerden oluşmaz. Kökleri M.Ö. 45 tarihinden bu yana klasik Latin edebiyatına kadar uzanan 2000 yıllık bir geçmişi vardır. Virginia'daki Hampden-Sydney College'dan Latince profesörü Richard McClintock, bir Lorem Ipsum pasajında geçen ve anlaşılması en güç sözcüklerden biri olan 'consectetur' sözcüğünün klasik edebiyattaki örneklerini incelediğinde kesin bir kaynağa ulaşmıştır.</p>
            <p>Lorm Ipsum, Çiçero tarafından M.Ö. 45 tarihinde kaleme alınan "de Finibus Bonorum et Malorum" (İyi ve Kötünün Uç Sınırları) eserinin 1.10.32 ve 1.10.33 sayılı bölümlerinden gelmektedir. Bu kitap, ahlak kuramı üzerine bir tezdir ve Rönesans döneminde çok popüler olmuştur. Lorem Ipsum pasajının ilk satırı olan "Lorem ipsum dolor sit amet" 1.10.32 sayılı bölümdeki bir satırdan gelmektedir.</p>
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