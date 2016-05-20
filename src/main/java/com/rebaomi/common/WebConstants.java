package com.rebaomi.common;

/**
 * @author Shawn Qian 此人是谁
 * @date 2014年5月13日
 */
public class WebConstants {
	/**
	 * session attribute 缓存用户信息
	 */
	public static final String SESSION_USER = "tfUser";
	public static final String SESSION_BROADCAST = "broadcast";

	public static final Integer ZERO = 0;
	public static final Integer ONE = 1;
	public static final Integer TWO = 2;
	public static final Integer THREE = 3;
	public static final Integer FOUR = 4;
	public static final Integer FIVE= 5;



	public static final Integer PAGE_SIZE= 10;

	public static final Integer INVALID_ORDER_STATUS =5;

	public static final Integer DOWN_ORDER_STATUS =1;

	public final static String COOPERATION = "cooperation";

	public final static String NO_COOPERATION = "no_cooperation";


	/**
	 * 订单状态
	 */
	public static final Integer BUYE_RRATE =1;


	/**
	 *  支付状态
	 */
	public static final Integer WX_PAY_STATUS =1;
	/**
	 *  支付状态
	 */
	public static final Integer IS_REFUNSE =1;
	/**
	 *  支付状态
	 */
	public static final Integer PAY_STATUS =2;

	/**
	 *  微信支付状态
	 */
	public static final String WX ="WX";

	/**
	 *  微信支付类型
	 */
	public static final Integer WX_TYPE = 1;


	/**
	 *  支付宝类型
	 */
	public static final Integer ALIPAY_TYPE = 2;

	/**
	 *  微信alipay
	 */
	public static final String ALIPAY ="ALIPAY";


	/**
	 *  支付状态
	 */
	public static final Integer ALIPAY_PAY_STATUS =1;

	/**
	 *  支付状态
	 */
	public static final String IS_SUCCESS ="Y";


	/**
	 *  支付状态
	 */
	public static final String PC ="PC";


	/**
	 *  支付状态
	 */
	public static final String WAP ="WAP";

	/**
	 *  支付状态
	 */
	public static final String SIGN_TYPE ="MD5";

	/**
	 *  支付状态
	 */
	public static final String TRADE_STATUS ="TRADE_SUCCESS";

	public static final String SESSION_Building = "tfBuilding";

	/*
	 * 每月修改手机的最大次数
	 */
	public static final Integer PHONE_MODIFIED_COUNT = 2;
	/*
	 */
	public static final Integer MULTI_RULE = 1;

	/**
	 * 分页的大小
	 */
	public static final int PER_PAGE_NUM = 4;
	/*
	 * 收藏的活动ID数组
	 */
	public static final String SESSION_ACTIVITYIDS ="activityIds";
	
	public static final String SESSION_BUILDINGIDS = "buildingIds";
	
	/*
	 * 登陆的Url
	 *
	 */

	public static final String LOGIN_URL = "/tfdd/login.htm";


	/*
	 * 注册的URL
	 */

	public static final String REGISTER_URL = "/tfdd/register.htm";


	/*
	 *
	 * 首页
	 */

	public static final String INDEX_URL = "/index.htm";



	/**
	 * 验证码失效的时间戳（毫秒）
	 *
	 */

	public static final Integer  CODE_INVALID_TIMESTAMP = 5*(60*1000);


	/**
	 * session设置验证码发送的时间的key
	 */

	public static final String SESSION_GMT_SEND_CODE =  "gmtSendCode";


	/**
	 *验证码类型(注册)
	 */
	public static final String SESSSION_CODE_TYPE_REGISTER = "register";


	/**
	 *验证码类型(更换手机号)
	 */

	public static final String SESSSION_CODE_TYPE_UPDATEPHONE = "updatePhone";


	/**
	 * 验证码类型(通过手机号找回密码)
	 */
	public static final String SESSSION_CODE_TYPE_RESET_PASSWORD_BY_PHONE = "SESSSION_CODE_TYPE_UPDATEPHONE";

	/*
	 * 开发商登陆页面
	 *
	 */
	public static final String DEV_LOGIN_URL = "/devPage/login.htm";


	/**
	 * 忘记密码页面
	 */
	public static final String FORGET_PASSWORD_URL = "/tfdd/forget.htm";

	/**
	 * 浏览量
	 */
	public static final String SKIM_NUM = "buildingSkimNum";
	public static final String SKIM_NUM_SPLIT = "_";
	
	/*
	 * session存放系统消息的总数
	 */
	public static final  String SESSION_COUNT_MESSAGE = "messageNum";

	public final static String RESERVE_CONTENT = "免费预约看房，享置业顾问一一对一服务。";

	public final static String RESERVE_TITLE = "免费看房";


	/*
	 * 公测发红包活动
	 */
	public static final String ACTIVITY_TITLE = "淘房点点公测-新用户免费领取红包";

	public static String WAP_APPID = "";
	public static String WAP_APPSECRET="";
	public static String WAP_PARTNERKEY="";

	/**
	 * 默认的评论内容
	 */
	public static String COMMENT_CONTENT = "十分满意";

	public static String HOUSE_TYPE_UNIT_CN = "平米";
	public static String HOUSE_TYPE_UNIT_EN = "㎡";
	public static String HOUSE_TYPE_SPLIT = "-";
	public static String HOUSE_TYPE_PATTERN = "(\\d*[.]?\\d*)";
	public static String HOUSE_TYPE_DEFAULT = "暂无户型";
	public static String HOUSE_TYPE_FORMAT = "%.2f";
	
	public static String DEFAULT_INQUIRE_PHONE = "0571-88269169";
	
	/**
	 * 默认经度
	 */
	public static String DEFAULT_LNG = "0";
	
	/**
	 * 默认纬度
	 */
	public static String DEFAULT_LAT = "0";
	
	/**
	 * 一周的毫秒数
	 * (7 * 24 * 60 * 60 * 1000)
	 */
	public static long A_WEEK_MILLISECOND = 604800000L;
	
	public final static String NO_PRE_NEWS = "没有了";
	
	public final static String NO_BACK_NEWS = "没有了";
	
	public final static String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";
	
	public final static String DEFAULT_CHARSETACTER_ENCODING = "utf-8";
}
