# eos_for_java_sdk
eos for java off line sign
# init service
EosRpcService rpc = new EosRpcService("https://api-kylin.eosasia.one");
# balance
List<String> balance = rpc.getCurrencyBalance("eosio.token", "eosqxyx11111", "EOS");
System.out.println(balance.get(0));

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
			if (actions != null) {
				List<Action> list = actions.getActions();
				System.out.println(actions.getLastIrreversibleBlock());
				System.out.println("===="+list.size());
				for (Action action : list) {
					System.out.println(action.getBlockNum());
//					ActionTrace actionTrace = action.getActionTrace();
					//{from=eosqxyx11111, to=eosqxyx22222, quantity=10.0000 EOS, memo=test}
					System.out.println(action.getBlockTime()+"  "+action.getActionTrace().getAct().getData().toString());
				}
			}
