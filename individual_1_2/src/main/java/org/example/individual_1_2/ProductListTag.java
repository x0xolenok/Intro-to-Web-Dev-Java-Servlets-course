package org.example.individual_1_2;

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
                    pageContext.getOut().write("<a href=\"" + editUrl + "\">" + product.getName() + " - " + product.getBrand() + "</a>");
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
