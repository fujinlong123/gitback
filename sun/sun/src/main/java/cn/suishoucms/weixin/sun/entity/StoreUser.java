package cn.suishoucms.weixin.sun.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table store_user
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class StoreUser {

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.store_id
     *
     * @mbggenerated
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.role
     *
     * @mbggenerated
     */
    private String role;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.fire
     *
     * @mbggenerated
     */
    private Integer fire;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.selected
     *
     * @mbggenerated
     */
    private Integer selected;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.id
     *
     * @return the value of store_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.id
     *
     * @param id the value for store_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.store_id
     *
     * @return the value of store_user.store_id
     *
     * @mbggenerated
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.store_id
     *
     * @param storeId the value for store_user.store_id
     *
     * @mbggenerated
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.user_id
     *
     * @return the value of store_user.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.user_id
     *
     * @param userId the value for store_user.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.role
     *
     * @return the value of store_user.role
     *
     * @mbggenerated
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.role
     *
     * @param role the value for store_user.role
     *
     * @mbggenerated
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.fire
     *
     * @return the value of store_user.fire
     *
     * @mbggenerated
     */
    public Integer getFire() {
        return fire;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.fire
     *
     * @param fire the value for store_user.fire
     *
     * @mbggenerated
     */
    public void setFire(Integer fire) {
        this.fire = fire;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_user.selected
     *
     * @return the value of store_user.selected
     *
     * @mbggenerated
     */
    public Integer getSelected() {
        return selected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_user.selected
     *
     * @param selected the value for store_user.selected
     *
     * @mbggenerated
     */
    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}
