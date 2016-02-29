文件一些说明，放在头部可有可无，如果有说明，可以是任意文字
queryList
===
SELECT * FROM t_user WHERE 1 = 1
@if(!isEmpty(phone)){
AND phone = #phone#
@}
