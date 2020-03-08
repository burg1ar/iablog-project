
insert into tb_user (user_id,user_name,name_to_show,password) values (1,'ai','burglar','$2a$10$04ugCMXvDhGYWAmo2uUJqeMefVCUfpkF581M.r/xgZ8HTJx.4oSnW');

insert into tb_role (role_id, description, role_name) values (1,'管理员','admin');
insert into tb_role (role_id, description, role_name) values (2,'普通用户','user');

insert into tb_permission (permission_id, description, permission_name, url) values (1,'增加用户','user:create','/api/user/create');
insert into tb_permission (permission_id, description, permission_name, url) values (2,'查询用户','user:retrieve','/api/user/retrieve');
insert into tb_permission (permission_id, description, permission_name, url) values (3,'更新用户','user:update','/api/user/update');
insert into tb_permission (permission_id, description, permission_name, url) values (4,'删除用户','user:delete','/api/user/delete');

insert into tb_user_role (user_id, role_id) values (1,1);

insert into tb_role_permission (role_id, permission_id) values (1,1);
insert into tb_role_permission (role_id, permission_id) values (1,2);
insert into tb_role_permission (role_id, permission_id) values (1,3);
insert into tb_role_permission (role_id, permission_id) values (1,4);

