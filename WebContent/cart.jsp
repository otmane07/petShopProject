 
 <%@include file="header.jsp" %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       
 
 
 <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My cart</div>
        	 
        	<div class="feat_prod_box_details">
            &gt;&gt; ${sessionScope.username}
            <br>
            <table class="cart_table">
            	<tr class="cart_title">
                	<td>Item pic</td>
                	<td>Product name</td>
                    <td>Unit price</td>
                    <td>Qty</td>
                    <td>Total</td>               
                </tr>
                
                
              
           
            <c:forEach items="${product_order}" var="p">
          
                <tr>
                	<td><a href="details.do?id=${p.getProduct_id()}"><img src="images/${p.getProduct_images()}" alt="" title="" border="0" class="cart_thumb" width="50%" /></a></td>
                	<td>${p.getProduct_name()}</td>
                    <td>${p.getPrice()}$</td>
                    <td>1</td>
                    <td>${p.getPrice()}$</td>               
                </tr>             
                   
         	</c:forEach> 
                
                
            	       
            

                <tr>
                <td colspan="4" class="cart_total"><span class="red">TOTAL SHIPPING:</span></td>
                <td>${total}$</td>                
                </tr>  
                
                <tr>
                <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                <td> ${total}$</td>                
                </tr>                  
            
            </table>
            <a href="#" class="continue">&lt; continue</a>
            <a href="#" class="checkout">checkout &gt;</a>
            

             
            
            </div>	
            
              

            

            
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <div class="right_content">
        
                <div class="languages_box">
			        <div id="google_translate_element"></div>
			
					<script type="text/javascript">
					function googleTranslateElementInit() {
					  new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element');
					}
					</script>
					
					<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
			

            </div>
                <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
                </div>
                
                
              <div class="cart">
		               <c:if test="${ !empty sessionScope.clientid }"> 
		                  <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" title="" /></span>My cart</div>
		                  <div class="home_cart_content">
		                  <span class="red">${sessionScope.username}</span>
		                  </div>
		                  <a href="cart.do?clientid=${sessionScope.clientid }" class="view_cart">view cart</a>
		              </c:if> 
		              </div>
        
             <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>About Our Shop</div> 
             <div class="about">
             <p>
             <img src="images/about.gif" alt="" title="" class="right" />
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
             </p>
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title="" /></span>Promotions</div> 
                   <c:forEach items="${products}" var="p">
                        <c:if test="${ p.getProduct_status().equals('promo')}"> 
		               
		               
	                    <div class="new_prod_box">
	                        <a href="details.do?id=${p.getProduct_id()}">${p.getProduct_name()}</a>
	                        <div class="new_prod_bg">
	                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>	                        
	                        <a href="details.do?id=${p.getProduct_id()}"><img src="images/${p.getProduct_images()}" alt="" title="" class="thumb" border="0" /></a>
	                        </div>           
	                    </div>         
	                    </c:if>         
         			</c:forEach>                 
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>Categories</div> 
                
                <ul class="list">
                  <c:forEach items="${Categorys}" var="p">
		                   
		                <li><a href="category.do?id=${p.getProduct_category_id()}">${p.getProduct_category_name()}</a></li>
		     
		                </c:forEach>                                              
                </ul>
                   
             
             </div>         
             
        
        </div><!--end of right content-->
        
        
       
       
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <div class="footer">
       	<div class="left_footer"><img src="images/footer_logo.gif" alt="" title="" /><br /> <a href="http://csscreme.com/freecsstemplates/" title="free css templates"><img src="images/csscreme.gif" alt="free css templates" border="0" /></a></div>
        <div class="right_footer">
        <a href="#">home</a>
        <a href="#">about us</a>
        <a href="#">services</a>
        <a href="#">privacy policy</a>
        <a href="#">contact us</a>
       
        </div>
        
       
       </div>
    

</div>

</body>
</html>