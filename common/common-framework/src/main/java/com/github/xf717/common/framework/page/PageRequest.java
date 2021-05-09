package com.github.xf717.common.framework.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页请求对象
 *
 * @author liaosq
 */
public class PageRequest implements Serializable {

  /**
   * The Enum Direction.
   *
   * @author l.xue.nong
   */
  public static enum Direction {

    /**
     * The asc.
     */
    ASC,

    /**
     * The desc.
     */
    DESC;

    /**
     * From string.
     *
     * @param value the value
     * @return the direction
     */
    public static Direction fromString(String value) {
      try {
        return Direction.valueOf(value.toUpperCase(Locale.US));
      } catch (Exception e) {
        throw new IllegalArgumentException(
            String.format(
                "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).",
                value), e);
      }
    }
  }

  /**
   * The Class Order.
   *
   * @author l.xue.nong
   */
  public static class Order implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 7939310426624426548L;
    private static final boolean DEFAULT_IGNORE_CASE = false;
    /**
     * The direction.
     */
    protected Direction direction;

    /**
     * The property.
     */
    protected String property;
    private final boolean ignoreCase;

    public Order() {
      super();
      this.ignoreCase = false;
    }

    /**
     * Instantiates a new order.
     *
     * @param property the property
     */
    public Order(String property) {
      this(Sort.DEFAULT_DIRECTION, property);
    }

    public Order(Direction direction, String property) {
      this(direction, property, DEFAULT_IGNORE_CASE);
    }

    /**
     * Instantiates a new order.
     *
     * @param direction the direction
     * @param property  the property
     */
    public Order(Direction direction, String property, boolean ignoreCase) {
      if (property == null || "".equals(property.trim())) {
        throw new IllegalArgumentException(
            "PropertyPath must not null or empty!");
      }
      this.direction = direction == null ? Sort.DEFAULT_DIRECTION
          : direction;
      this.property = property;
      this.ignoreCase = ignoreCase;
    }

    /**
     * Creates the.
     *
     * @param direction  the direction
     * @param properties the properties
     * @return the list
     */
    public static List<Order> create(Direction direction,
        Iterable<String> properties) {
      List<Order> orders = new ArrayList<Order>();
      for (String property : properties) {
        orders.add(new Order(direction, property));
      }
      return orders;
    }

    /**
     * Gets the direction.
     *
     * @return the direction
     */
    public Direction getDirection() {
      return direction;
    }

    /**
     * Gets the property.
     *
     * @return the property
     */
    public String getProperty() {
      return property;
    }

    /**
     * Checks if is ascending.
     *
     * @return true, if is ascending
     */
    public boolean isAscending() {
      return this.direction.equals(Direction.ASC);
    }

    public boolean isIgnoreCase() {
      return ignoreCase;
    }

    /**
     * With.
     *
     * @param order the order
     * @return the order
     */
    public Order with(Direction order) {
      return new Order(order, this.property);
    }

    /**
     * With properties.
     *
     * @param properties the properties
     * @return the sort
     */
    public Sort withProperties(String... properties) {
      return new Sort(this.direction, properties);
    }

    public Order ignoreCase() {
      return new Order(direction, property, true);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + direction.hashCode();
      result = 31 * result + property.hashCode();
      return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Order)) {
        return false;
      }
      Order that = (Order) obj;
      return this.direction.equals(that.direction)
          && this.property.equals(that.property);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
      return String.format("%s: %s", property, direction);
    }

    /**
     * Sets the direction.
     *
     * @param direction the new direction
     */
    public void setDirection(Direction direction) {
      this.direction = direction;
    }

    /**
     * Sets the property.
     *
     * @param property the new property
     */
    public void setProperty(String property) {
      this.property = property;
    }

  }

  /**
   * The Class Sort.
   *
   * @author l.xue.nong
   */
  public static class Sort implements Serializable, Iterable<Order> {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 3299629992844216097L;

    /**
     * The Constant DEFAULT_DIRECTION.
     */
    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    /**
     * The orders.
     */
    private List<Order> orders = new ArrayList<Order>();

    /**
     * Instantiates a new sort.
     */
    public Sort() {
      super();
    }

    /**
     * Instantiates a new sort.
     *
     * @param orders the orders
     */
    public Sort(Order... orders) {
      this(Arrays.asList(orders));
    }

    /**
     * Instantiates a new sort.
     *
     * @param orders the orders
     */
    public Sort(List<Order> orders) {
      if (null == orders || orders.isEmpty()) {
        throw new IllegalArgumentException(
            "You have to provide at least one sort property to sort by!");
      }
      this.orders = orders;
    }

    /**
     * Instantiates a new sort.
     *
     * @param properties the properties
     */
    public Sort(String... properties) {
      this(DEFAULT_DIRECTION, properties);
    }

    /**
     * Instantiates a new sort.
     *
     * @param direction  the direction
     * @param properties the properties
     */
    public Sort(Direction direction, String... properties) {
      this(direction, properties == null ? new ArrayList<String>()
          : Arrays.asList(properties));
    }

    /**
     * Instantiates a new sort.
     *
     * @param direction  the direction
     * @param properties the properties
     */
    public Sort(Direction direction, List<String> properties) {
      if (properties == null || properties.isEmpty()) {
        throw new IllegalArgumentException(
            "You have to provide at least one property to sort by!");
      }
      this.orders = new ArrayList<Order>(properties.size());
      for (String property : properties) {
        this.orders.add(new Order(direction, property));
      }
    }

    /**
     * And.
     *
     * @param sort the sort
     * @return the sort
     */
    public Sort and(Sort sort) {
      if (sort == null) {
        return this;
      }
      ArrayList<Order> these = new ArrayList<Order>(this.orders);
      for (Order order : sort) {
        these.add(order);
      }
      return new Sort(these);
    }

    /**
     * Gets the order for.
     *
     * @param property the property
     * @return the order for
     */
    public Order getOrderFor(String property) {
      for (Order order : this) {
        if (order.getProperty().equals(property)) {
          return order;
        }
      }
      return null;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + orders.hashCode();
      return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Sort)) {
        return false;
      }
      Sort that = (Sort) obj;
      return this.orders.equals(that.orders);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
      return StringUtils.join(orders, ",");
    }

    /**
     * Gets the orders.
     *
     * @return the orders
     */
    public List<Order> getOrders() {
      return orders;
    }

    /**
     * Sets the orders.
     *
     * @param orders the new orders
     */
    public void setOrders(List<Order> orders) {
      this.orders = orders;
    }

    @Override
    public Iterator<Order> iterator() {
      return this.orders.iterator();
    }

  }

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = 282080677164089234L;

  /**
   * The page no.
   */
  protected int pageNo = 1;

  /**
   * The page size.
   */
  protected int pageSize = 10;

  /**
   * The count total.
   */
  protected boolean countTotal = true;

  /**
   * The sort.
   */
  protected Sort sort;

  /**
   * Instantiates a new page request.
   */
  public PageRequest() {
  }

  /**
   * Instantiates a new page request.
   *
   * @param pageNo   the page no
   * @param pageSize the page size
   */
  public PageRequest(int pageNo, int pageSize) {
    setPageNo(pageNo);
    setPageSize(pageSize);
  }

  /**
   * Gets the page no.
   *
   * @return the page no
   */
  public int getPageNo() {
    return pageNo;
  }

  /**
   * Sets the page no.
   *
   * @param pageNo the new page no
   */
  public void setPageNo(final int pageNo) {
    this.pageNo = pageNo;
    if (pageNo < 1) {
      this.pageNo = 1;
    }
  }

  /**
   * Gets the page size.
   *
   * @return the page size
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets the page size.
   *
   * @param pageSize the new page size
   */
  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize;
    if (pageSize < 1) {
      this.pageSize = 1;
    }
  }

  /**
   * Gets the sort.
   *
   * @return the sort
   */
  public Sort getSort() {
    return sort;
  }

  /**
   * Sets the sort.
   *
   * @param sort the new sort
   */
  public void setSort(Sort sort) {
    this.sort = sort;
  }

  /**
   * Checks if is count total.
   *
   * @return true, if is count total
   */
  public boolean isCountTotal() {
    return countTotal;
  }

  /**
   * Sets the count total.
   *
   * @param countTotal the new count total
   */
  public void setCountTotal(boolean countTotal) {
    this.countTotal = countTotal;
  }

  /**
   * Gets the offset.
   *
   * @return the offset
   */
  public int getOffset() {
    return ((pageNo - 1) * pageSize);
  }
}
