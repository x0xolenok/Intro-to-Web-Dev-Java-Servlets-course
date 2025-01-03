package org.example.individual;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class ProductListTag extends TagSupport {

    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (products == null || products.isEmpty()) {
                pageContext.getOut().write("<p>No products available.</p>");
            } else {
                pageContext.getOut().write("<ul>");
                for (Product product : products) {
                    String editUrl = "editProduct?id=" + product.getId();
                    pageContext.getOut().write("<li>");
                    pageContext.getOut().write("<h3>" + product.getName() + " " + product.getBrand() +  " </h3>");
                    pageContext.getOut().write("<h3>Price: " + product.getPrice() + " </h3>" );
                    pageContext.getOut().write("<p>Description: " + product.getDescription() + " </p>" );
                    pageContext.getOut().write("<a href=\"" + editUrl + "\">" + "Edit" + "</a>");
                    pageContext.getOut().write("</li>");
                }
                pageContext.getOut().write("</ul>");
            }
        } catch (Exception e) {
            throw new JspException("Error in ProductListTag", e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
