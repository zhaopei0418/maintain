-- 初始化用户
insert into member(code, name, password) values('03d0b83b5f240f547e4d967484caba0e', 'zhaopei', '06efe62e732862855dad02e617125fb1');
insert into member(code, name, password) values('21232f297a57a5a743894a0e4a801fc3', 'admin', '6f919627e922fd0681aecd91491e8a07');

-- 初始化角色
insert into role(code, name, descript) values('21232f297a57a5a743894a0e4a801fc3', 'admin', '管理员');

-- 初始化组
insert into sys_group(code, name, descript) values('21232f297a57a5a743894a0e4a801fc3', 'admin', '管理员');
insert into sys_group(code, name, descript) values('ee11cbb19052e40b07aac0ca060c23ee', 'user', '普通用户');

-- 初始化组－角色
insert into group_rel_role(group_code, role_code) values('21232f297a57a5a743894a0e4a801fc3', '21232f297a57a5a743894a0e4a801fc3');

-- 初始化组－用户关系
insert into group_rel_member(group_code, member_code) values('21232f297a57a5a743894a0e4a801fc3', '03d0b83b5f240f547e4d967484caba0e');
insert into group_rel_member(group_code, member_code) values('21232f297a57a5a743894a0e4a801fc3', '21232f297a57a5a743894a0e4a801fc3');

-- 初始化权限
insert into permission(code, name, descript, url) values('106a6c241b8797f52e1e77317b96a201', 'home', '首页', '/');
insert into permission(code, name, descript, url) values('4ed85096363f03230cfa5111401a7954', 'invt', '清单管理', '/invts/**');
insert into permission(code, name, descript, url) values('5feb1ca81ab94e05a2e9ee3ccef2b386', 'invt_statistics', '清单统计管理', '/invts/statistics/**');
insert into permission(code, name, descript, url) values('06565e5611f23fdf8cc43e5077b92b54', 'tax', '税单管理', '/taxes/**');
insert into permission(code, name, descript, url) values('de89089b3f28523876061b4a1f8c9f69', 'dxp', '报文管理', '/dxps/**');
insert into permission(code, name, descript, url) values('6160279f43716dc02da97bbbcd1e952d', 'invt_cancel', '撤销单管理', '/invtCancel/**');
insert into permission(code, name, descript, url) values('7108537956afa2a526f96cc9da7b0c36', 'delivery', '入库明细单管理', '/deliveries/**');
insert into permission(code, name, descript, url) values('3a35e25bbe1e0e4c82a679ba991fd9f3', 'check_good', '光机指令管理', '/checkGoods/**');
insert into permission(code, name, descript, url) values('8b0a44048f58988b486bdd0d245b22a8', 'person', '身份认证管理', '/persons/**');
insert into permission(code, name, descript, url) values('70a17ffa722a3985b86d30b034ad06d7', 'order', '订单管理', '/orders/**');
insert into permission(code, name, descript, url) values('9b7817dceaaf44106fce1b9357a1ff9a', 'logistics', '运单管理', '/logistics/**');
insert into permission(code, name, descript, url) values('f83c2a85d972a89238f31296c63f0dbc', 'payment', '支付单管理', '/payments/**');
insert into permission(code, name, descript, url) values('2a6d07eef8b10b84129b42424ed99327', 'dist', '核放单管理', '/dists/**');
insert into permission(code, name, descript, url) values('5a76e813d6a0a40548b91acc11557bd2', 'vehicle', '车辆管理', '/vehicles/**');
insert into permission(code, name, descript, url) values('755f85c2723bb39381c7379a604160d8', 'good', '商品管理', '/goods/**');
insert into permission(code, name, descript, url) values('ee11cbb19052e40b07aac0ca060c23ee', 'user', '用户管理', '/users/**');

-- 初始化角色－权限关系
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '106a6c241b8797f52e1e77317b96a201');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '4ed85096363f03230cfa5111401a7954');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '06565e5611f23fdf8cc43e5077b92b54');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', 'de89089b3f28523876061b4a1f8c9f69');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '6160279f43716dc02da97bbbcd1e952d');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '7108537956afa2a526f96cc9da7b0c36');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '3a35e25bbe1e0e4c82a679ba991fd9f3');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '8b0a44048f58988b486bdd0d245b22a8');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '70a17ffa722a3985b86d30b034ad06d7');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '9b7817dceaaf44106fce1b9357a1ff9a');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', 'f83c2a85d972a89238f31296c63f0dbc');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '2a6d07eef8b10b84129b42424ed99327');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '5a76e813d6a0a40548b91acc11557bd2');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '755f85c2723bb39381c7379a604160d8');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', 'ee11cbb19052e40b07aac0ca060c23ee');
insert into role_rel_permission(role_code, permission_code) values('21232f297a57a5a743894a0e4a801fc3', '5feb1ca81ab94e05a2e9ee3ccef2b386');

commit;
