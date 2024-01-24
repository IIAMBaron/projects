
package pizzalore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pizzalore package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProdTypesResponse_QNAME = new QName("http://pizzaLore/", "prodTypesResponse");
    private final static QName _OrderInfo_QNAME = new QName("http://pizzaLore/", "orderInfo");
    private final static QName _ProductsResponse_QNAME = new QName("http://pizzaLore/", "productsResponse");
    private final static QName _OrderDetails_QNAME = new QName("http://pizzaLore/", "orderDetails");
    private final static QName _Products_QNAME = new QName("http://pizzaLore/", "products");
    private final static QName _Sales_QNAME = new QName("http://pizzaLore/", "sales");
    private final static QName _HomePage_QNAME = new QName("http://pizzaLore/", "homePage");
    private final static QName _Login_QNAME = new QName("http://pizzaLore/", "login");
    private final static QName _AddProductResponse_QNAME = new QName("http://pizzaLore/", "addProductResponse");
    private final static QName _AddProduct_QNAME = new QName("http://pizzaLore/", "addProduct");
    private final static QName _OrderDetailsResponse_QNAME = new QName("http://pizzaLore/", "orderDetailsResponse");
    private final static QName _OrderInfoResponse_QNAME = new QName("http://pizzaLore/", "orderInfoResponse");
    private final static QName _ProdTypes_QNAME = new QName("http://pizzaLore/", "prodTypes");
    private final static QName _Address_QNAME = new QName("http://pizzaLore/", "address");
    private final static QName _LoginResponse_QNAME = new QName("http://pizzaLore/", "loginResponse");
    private final static QName _AddressResponse_QNAME = new QName("http://pizzaLore/", "addressResponse");
    private final static QName _SalesResponse_QNAME = new QName("http://pizzaLore/", "salesResponse");
    private final static QName _HomePageResponse_QNAME = new QName("http://pizzaLore/", "homePageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pizzalore
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HomePageResponse }
     * 
     * @return 
     */
    public HomePageResponse createHomePageResponse() {
        return new HomePageResponse();
    }

    /**
     * Create an instance of {@link AddressResponse }
     * 
     * @return 
     */
    public AddressResponse createAddressResponse() {
        return new AddressResponse();
    }

    /**
     * Create an instance of {@link SalesResponse }
     * 
     * @return 
     */
    public SalesResponse createSalesResponse() {
        return new SalesResponse();
    }

    /**
     * Create an instance of {@link Address }
     * 
     * @return 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     * @return 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     * @return 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link OrderDetailsResponse }
     * 
     * @return 
     */
    public OrderDetailsResponse createOrderDetailsResponse() {
        return new OrderDetailsResponse();
    }

    /**
     * Create an instance of {@link OrderInfoResponse }
     * 
     * @return 
     */
    public OrderInfoResponse createOrderInfoResponse() {
        return new OrderInfoResponse();
    }

    /**
     * Create an instance of {@link ProdTypes }
     * 
     * @return 
     */
    public ProdTypes createProdTypes() {
        return new ProdTypes();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     * @return 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     * @return 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link HomePage }
     * 
     * @return 
     */
    public HomePage createHomePage() {
        return new HomePage();
    }

    /**
     * Create an instance of {@link Sales }
     * 
     * @return 
     */
    public Sales createSales() {
        return new Sales();
    }

    /**
     * Create an instance of {@link Products }
     * 
     * @return 
     */
    public Products createProducts() {
        return new Products();
    }

    /**
     * Create an instance of {@link OrderDetails }
     * 
     * @return 
     */
    public OrderDetails createOrderDetails() {
        return new OrderDetails();
    }

    /**
     * Create an instance of {@link ProductsResponse }
     * 
     * @return 
     */
    public ProductsResponse createProductsResponse() {
        return new ProductsResponse();
    }

    /**
     * Create an instance of {@link OrderInfo }
     * 
     * @return 
     */
    public OrderInfo createOrderInfo() {
        return new OrderInfo();
    }

    /**
     * Create an instance of {@link ProdTypesResponse }
     * 
     * @return 
     */
    public ProdTypesResponse createProdTypesResponse() {
        return new ProdTypesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProdTypesResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "prodTypesResponse")
    public JAXBElement<ProdTypesResponse> createProdTypesResponse(ProdTypesResponse value) {
        return new JAXBElement<ProdTypesResponse>(_ProdTypesResponse_QNAME, ProdTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInfo }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "orderInfo")
    public JAXBElement<OrderInfo> createOrderInfo(OrderInfo value) {
        return new JAXBElement<OrderInfo>(_OrderInfo_QNAME, OrderInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductsResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "productsResponse")
    public JAXBElement<ProductsResponse> createProductsResponse(ProductsResponse value) {
        return new JAXBElement<ProductsResponse>(_ProductsResponse_QNAME, ProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDetails }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "orderDetails")
    public JAXBElement<OrderDetails> createOrderDetails(OrderDetails value) {
        return new JAXBElement<OrderDetails>(_OrderDetails_QNAME, OrderDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Products }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "products")
    public JAXBElement<Products> createProducts(Products value) {
        return new JAXBElement<Products>(_Products_QNAME, Products.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sales }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "sales")
    public JAXBElement<Sales> createSales(Sales value) {
        return new JAXBElement<Sales>(_Sales_QNAME, Sales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HomePage }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "homePage")
    public JAXBElement<HomePage> createHomePage(HomePage value) {
        return new JAXBElement<HomePage>(_HomePage_QNAME, HomePage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDetailsResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "orderDetailsResponse")
    public JAXBElement<OrderDetailsResponse> createOrderDetailsResponse(OrderDetailsResponse value) {
        return new JAXBElement<OrderDetailsResponse>(_OrderDetailsResponse_QNAME, OrderDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInfoResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "orderInfoResponse")
    public JAXBElement<OrderInfoResponse> createOrderInfoResponse(OrderInfoResponse value) {
        return new JAXBElement<OrderInfoResponse>(_OrderInfoResponse_QNAME, OrderInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProdTypes }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "prodTypes")
    public JAXBElement<ProdTypes> createProdTypes(ProdTypes value) {
        return new JAXBElement<ProdTypes>(_ProdTypes_QNAME, ProdTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "addressResponse")
    public JAXBElement<AddressResponse> createAddressResponse(AddressResponse value) {
        return new JAXBElement<AddressResponse>(_AddressResponse_QNAME, AddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalesResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "salesResponse")
    public JAXBElement<SalesResponse> createSalesResponse(SalesResponse value) {
        return new JAXBElement<SalesResponse>(_SalesResponse_QNAME, SalesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HomePageResponse }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://pizzaLore/", name = "homePageResponse")
    public JAXBElement<HomePageResponse> createHomePageResponse(HomePageResponse value) {
        return new JAXBElement<HomePageResponse>(_HomePageResponse_QNAME, HomePageResponse.class, null, value);
    }

}
