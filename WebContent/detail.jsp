<%@include file="header.jsp" %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index.do">home</a> &gt;&gt; ${product_selected.product_name}
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Product name</div>
        
        	<div class="feat_prod_box_details">
            
            	<div class="prod_img"><a><img src="images/${product_selected.getProduct_images()}" alt="" title="" border="0" /></a>
                <br /><br />
                <a href="images/${product_selected.getProduct_images()}" rel="lightbox"><img src="images/zoom.gif" alt="" title="" border="0" /></a>
                </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Details</div>
                    <p class="details">${product_selected.product_description} </p>
                    <div class="price"><strong>PRICE:</strong> <span class="red">${product_selected.getPrice()} $</span></div>
                    <div class="price"><strong>COLORS:</strong> 
                    <span class="colors"><img src="images/color1.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color2.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color3.gif" alt="" title="" border="0" /></span>                    
                    </div>
                    
                    
                     <c:if test="${ !empty sessionScope.clientid }"> 
		                  <a href="order.do?clientid=${sessionScope.clientid}&product_id=${product_selected.product_id}" class="more"><img src="images/order_now.gif" alt="" title="" border="0" /></a>
		             </c:if>
		              
		              
	               <c:if test="${ empty sessionScope.clientid }">
           	 	      <a href="myaccount.do" class="more"><img src="images/order_now.gif" alt="" title="" border="0" /></a>

           	       </c:if>
                    
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
              
            <div id="demo" class="demolayout">

                <ul id="demo-nav" class="demolayout">
                <li><a class="active" href="#tab1">More details</a></li>
                </ul>
    
            <div class="tabs-container">
            
                    <div style="display: block;" class="tab" id="tab1">
                                        <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>
                            <ul class="list">
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>                                          
                            </ul>
                                         <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>                           
                    </div>	
                    
                      
            
            </div>


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
                <a  class="selected" >GBP</a>
                <a  class="selected">EUR</a>
                <a  class="selected" >USD</a>
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
<script type="text/javascript">

var tabber1 = new Yetii({
id: 'demo'
});

</script>
</html>