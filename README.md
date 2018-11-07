# eos_for_java_sdk
eos for java off line sign
# init service
EosRpcService rpc = new EosRpcService("https://api-kylin.eosasia.one");
# balance
List<String> balance = rpc.getCurrencyBalance("eosio.token", "eosqxyx11111", "EOS");
System.out.println(balance.get(0));
	
# create account
Transaction t2 = rpc.createAccount("5KBWYsYudu9APDdUrHVPPDdyVMhjrRVq3zqDAEzhuogDR3caApb","machaoxiaoai","tokyohot1111", "EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV","EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV", 8164l, "0.1000 EOS","0.1000 EOS", 0l);
System.out.println("创建成功 = " + t2.getTransactionId()+" \n ");
# account
Account account = rpc.getAccount("eosqxyx11111");
# eos transfer
Transaction t1 = rpc.transfer("5JJB2oiCXwASK9fumjyTgbtHcwDVedVRaZda1kBhFuQcmjnrDWB","eosio.token", "eosqxyx11111","eosqxyx22222", "10.0000 EOS", "te1");
System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
# token transfer
Transaction t1 = rpc.transfer("5KBWYsYudu9APDdUrHVPPDdyVMhjrRVq3zqDAEzhuogDR3caApb","machaoxiaoai", "machaoxiaoai","test12344444", "10.0000 SYS", "");
System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
# getActions 
Actions actions = rpc.getActions("eosqxyx22222", 0, 10);
