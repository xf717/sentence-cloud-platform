CREATE DATABASE maruko_user DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
Use maruko_user;
/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.86
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 192.168.0.86:3306
 Source Schema         : maruko_user

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/06/2019 22:42:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `province_id` int(11) NOT NULL COMMENT '省分id',
  `city_id` int(11) NOT NULL COMMENT '市ID',
  `county_id` int(11) NOT NULL COMMENT '县区id',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人',
  `is_default` tinyint(2) NOT NULL COMMENT '是否默认',
  `alias` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '别名',
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注',
  `create_time` bigint(14) NOT NULL COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `modify_time` bigint(14) NOT NULL COMMENT '修改时间',
  `modify_by` int(11) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_extend
-- ----------------------------
DROP TABLE IF EXISTS `user_extend`;
CREATE TABLE `user_extend`  (
  `user_extend_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户信息id',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'email',
  `gender` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '字典:性别(1男、2女、0未知)',
  `birthday_year` smallint(4) NOT NULL DEFAULT 2000 COMMENT '出生年',
  `birthday_month` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '出身月',
  `birthday_day` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '出生日',
  `reg_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '注册时间',
  `reg_ip` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '注册ip',
  `reg_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户注册类型(1.手机 2.第三方3.邮箱)',
  `reg_source` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '注册来源：1平台（默认1）,2其它',
  `expire_freeze` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '帐号冻结时间',
  `reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帐号冻结原因',
  `terminal_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6小程序)',
  `terminal_sn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '终端唯一',
  `terminal_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '终端名称',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_extend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_扩展表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_goods_collect
-- ----------------------------
DROP TABLE IF EXISTS `user_goods_collect`;
CREATE TABLE `user_goods_collect`  (
  `user_list_collect_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `user_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `goods_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品ID',
  `is_collect` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否收藏(1:是,0:否,默认为1)',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_list_collect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_商品收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `user_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '加盐',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '绑定手机',
  `signature` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '个性签名',
  `photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户头像',
  `user_status` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户状态(1正常、2冻结,默认为1),关联字典项：item_no',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_帐号信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_integral
-- ----------------------------
DROP TABLE IF EXISTS `user_integral`;
CREATE TABLE `user_integral`  (
  `user_integral_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `user_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `total_integral` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总积分',
  `integral` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_integral_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_积分表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_third
-- ----------------------------
DROP TABLE IF EXISTS `user_third`;
CREATE TABLE `user_third`  (
  `user_third_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `user_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账号id',
  `third_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 2 COMMENT '第三方类型',
  `access_token` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'access_token',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称,冗余字段',
  `photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像,冗余字段',
  `gender` tinyint(2) NOT NULL DEFAULT 0 COMMENT '性别(1男、2女、0未知),冗余字段',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_third_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_第三方表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type`  (
  `user_type_id` tinyint(2) UNSIGNED NOT NULL COMMENT 'id(不能做成自增长)',
  `user_type_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户类型名称',
  `create_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `create_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `modify_time` bigint(14) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改时间',
  `modify_by` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  PRIMARY KEY (`user_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_类型表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
