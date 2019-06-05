CREATE DATABASE maruko_goods DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
Use maruko_goods;
/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.86
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 192.168.0.86:3306
 Source Schema         : maruko_goods

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/06/2019 22:38:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌主键id',
  `brand_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌名称',
  `acronym` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '首字母',
  `create_time` bigint(14) NOT NULL COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `modify_time` bigint(14) NOT NULL COMMENT '修改时间',
  `modify_by` int(11) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '品牌' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌主键id',
  `seller_id` int(11) NOT NULL COMMENT '商家id',
  `goods_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SPU名',
  `default_item_id` int(11) NOT NULL COMMENT '默认SKU',
  `audit_status` tinyint(2) NOT NULL COMMENT '审核状态',
  `is_marketable` tinyint(1) NOT NULL COMMENT '是否上架',
  `brand_id` int(11) NOT NULL COMMENT '品牌ID',
  `caption` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品说明',
  `category1_id` int(11) NOT NULL COMMENT '一级类目',
  `category2_id` int(11) NOT NULL COMMENT '二级类目',
  `category3_id` int(11) NOT NULL COMMENT '三级类目',
  `small_pic` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '小图',
  `price` decimal(10, 2) NOT NULL COMMENT '简介',
  `type_template_id` int(11) NOT NULL COMMENT '分类模板ID',
  `is_enable_spec` tinyint(1) NOT NULL COMMENT '是否启用规格',
  `is_del` tinyint(1) NOT NULL COMMENT '是否删除',
  `create_time` bigint(14) NOT NULL COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `modify_time` bigint(14) NOT NULL COMMENT '修改时间',
  `modify_by` int(11) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller`  (
  `seller_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌主键id',
  `seller_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商家名称',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码加盐',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `status` tinyint(2) NOT NULL COMMENT '状态',
  `create_time` bigint(14) NOT NULL COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `modify_time` bigint(14) NOT NULL COMMENT '修改时间',
  `modify_by` int(11) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`seller_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商家' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seller_extend
-- ----------------------------
DROP TABLE IF EXISTS `seller_extend`;
CREATE TABLE `seller_extend`  (
  `seller_extend_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌主键id',
  `seller_id` int(11) NOT NULL COMMENT '商家id',
  `address_detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `linkman_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人姓名',
  `linkman_qq` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人QQ',
  `linkman_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人手机号码',
  `linkman_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人邮箱',
  `license_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '营业执照',
  `tax_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '税务登记号',
  `org_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '组织机构代码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公司地址',
  `logo_pic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公司LOGO',
  `brief_introduction` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '简介',
  `legal_person` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法人代表',
  `id_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法人身份证',
  `bank_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '开户行账号名称',
  `bank_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '开户行',
  `create_time` bigint(14) NOT NULL COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `modify_time` bigint(14) NOT NULL COMMENT '修改时间',
  `modify_by` int(11) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`seller_extend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商家' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
