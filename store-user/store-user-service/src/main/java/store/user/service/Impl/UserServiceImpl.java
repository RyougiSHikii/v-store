package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.user.common.util.PasswordUtils;
import store.user.common.util.UserUtils;
import store.user.entity.User;
import store.user.entity.UserLoginLog;
import store.user.mapper.UserLoginLogMapper;
import store.user.mapper.UserMapper;
import store.user.pojo.vo.UserVO;
import store.user.service.IUserService;

import java.util.Date;

/**
 * author  violet
 * createTime 2019/3/26 15:25
 * description 用户管理服务
 * version 1.0
 */
@RestController
@Api("用户服务")
@RequestMapping("/userService")
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    private final UserLoginLogMapper userLoginLogMapper;

    public UserServiceImpl(UserMapper userMapper, UserLoginLogMapper userLoginLogMapper) {
        this.userMapper = userMapper;
        this.userLoginLogMapper = userLoginLogMapper;
    }


    @Override
    @ApiOperation("完善个人信息")
    @PostMapping("/perfectUser")
    public Integer perfectUser(String email, String realName, String telephone) throws ValidationException {
        User userByLoginName = userMapper.getByLoginName(email);
        if (telephone.equals(userByLoginName.getTelephone())) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "手机号已被注册");
        }
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("email", email);
        userByLoginName.setRealName(realName);
        userByLoginName.setTelephone(telephone);
        userByLoginName.setUpdateTime(new Date());
        userByLoginName.setUpdateBy(email);
        return userMapper.update(userByLoginName, userUpdateWrapper);
    }

    @Override
    @ApiOperation("获取用户信息")
    @PostMapping("/getByLoginName")
    public User getByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    @ApiOperation("获取用户信息")
    @PostMapping("/getUserVOById")
    public UserVO getUserVOById(Long userId) {
        UserVO userVO = userMapper.getUserVOById(userId);
        userVO.setEmail(UserUtils.encryptEmail(userVO.getEmail()));
        userVO.setTelephone(UserUtils.encryptTelephone(userVO.getTelephone()));
        return userVO;
    }

    @Override
    @ApiOperation("更新密码")
    @PostMapping("/updatePasswordByEmail")
    public Integer updatePasswordByEmail(String password, String email) {

        return null;
    }

    @Override
    @ApiOperation("激活邮箱")
    @PostMapping("/activeEmail")
    public Integer activeEmail(String email) {
        User user = new User();
        user.setEmailIsActive(StatusEnum.ACTIVATED.getStatus());
        user.setUpdateBy(email);
        user.setUpdateTime(new Date());

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("email", email);
        return userMapper.update(user, userUpdateWrapper);
    }

    @Override
    @ApiOperation("获取用户信息")
    @PostMapping("/getUserByLoginName")
    public User getUserByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    @ApiOperation("更新用户信息")
    @PostMapping("/updateLogById")
    public Integer updateLogById(UserLoginLog userLoginLog) {
        User user = new User();
        user.setUserId(userLoginLog.getUserId());
        user.setLastLoginIp(userLoginLog.getUserIp());
        user.setLastLoginTime(userLoginLog.getLoginTime());
        userMapper.updateById(user);
        return userLoginLogMapper.insert(userLoginLog);
    }

    @Override
    @ApiOperation("新增用户")
    @PostMapping("/insertUser")
    public Integer insertUser(User user) throws ValidationException {
        //验证邮箱是否存在或使用
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("email", user.getEmail());

        User userEmail = userMapper.selectOne(userQueryWrapper);
        if (userEmail != null && StatusEnum.ACTIVATED.getStatus().equals(userEmail.getEmailIsActive())) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "邮箱已被注册");
        }
        if (userEmail != null) {
            userMapper.deleteById(userEmail.getUserId());//未被激活删除用户
        }
        user.setCreateBy(user.getUserName());
        user.setSalt(PasswordUtils.getSalt());
        user.setPicImg(UserUtils.getPicImg());
        user.setUserNumber(UserUtils.getUserNumber());
        user.setRegisterTime(new Date());
        user.setLoginPassword(PasswordUtils.getMd5(user.getLoginPassword(), user.getUserNumber(), user.getSalt()));
        return userMapper.insert(user);
    }
}
