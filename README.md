# eos_for_java_sdk
eos for java off line sign

System.out.println("******************* Ecc Start *******************\n");		
		System.out.println("============= 通过种子生成私钥 ===============");
		String pk = Ecc.seedPrivate("!@#$%^&*(lajdlkjaksjdlkjaskldM<>?87126162kajsdjlaksd kajdlkaslkd heiuheijpe f[a- si0ausd9asd ahsdvcyasdcasdc ajhsdg8ca"
				+ "we asds JHDKAHDKKASDKJALSKDKA ooidjajsdua09sid0asdo[paksdajsdlklasdmlk FJKLIKNLK;B/;LP[P'NC;PO'; OOPO;L0["
				+ "XP'C'[FG["
				+ "19218728909107328972309289832098012");
//		String pk = Ecc.seedPrivate("81805b06b346d862b8386ad538da03b3cf220a7e5bce1510addc4311711ed3296c71e3fda664d222a33bbe1429bc4cf7c1b1f4526453899928281884afa2ca1e");
		System.out.println("private key :" + pk +"\n");
		System.out.println("============= 通过私钥生成公钥 ===============");
		String pu = Ecc.privateToPublic(pk);
		System.out.println("public key :" + pu + " \n ");

		System.out.println("============= 自定义数据签名 ===============");
		String sign = Ecc.sign(pk,"is京東價as看到可可是是是@#￥%……&*（CVBNM《d ");
		System.out.println("sign :" + sign + " \n ");
		
		System.out.println("============= 转账数据序列化 ===============");
		String data = Ecc.parseTransferData("fromaccount", "toaccount", "10.0020 SYS", "测试123abcdo./,./!@##$%");
		System.out.println("seriz data :" + data);
		System.out.println("transfer eq eosjs seriz " + data.equals(eosjs_transfer_seriz)+" \n ");

		System.out.println("============= 创建账户数据序列化 ===============");
		String data1 = Ecc.parseAccountData("eosio", "espritbloc1.","EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx","EOS8FPooohZiiCAYXahWCQRxgXXzUbS2gNELAeYCUgGdDMbd2FHQT");
		System.out.println("seriz data :" + data1);
		System.out.println("account eq eosjs seriz " + data1.equals(eosjs_account_seriz));

		System.out.println("\n******************* Ecc End *******************\n\n\n");
		
		System.out.println("******************* Rpc Start *******************\n");
		
		//测试网
//		Rpc rpc = new Rpc("http://ayeaye.cypherglass.com:8888");// http://jungle.cryptolions.io:38888
		//主网
//		Rpc rpc = new Rpc("http://130.211.59.178:8888");
//		Rpc rpc = new Rpc("http://api.eosnewyork.io:80");
		EosRpcService rpc = new EosRpcService("https://api-kylin.eosasia.one");
		
		List<String> balance = rpc.getCurrencyBalance("eosio.token", "eosqxyx11111", "EOS");
		System.out.println(balance.get(0));
		Account account = rpc.getAccount("eosqxyx11111");
		System.out.println(account.toString());
		System.out.println("============= 转账EOS ===============");
		try {
			//eos转账
			Transaction t1 = rpc.transfer("5JJB2oiCXwASK9fumjyTgbtHcwDVedVRaZda1kBhFuQcmjnrDWB","eosio.token", "eosqxyx11111","eosqxyx22222", "10.0000 EOS", "te1");
			//代币转账
//			Transaction t1 = rpc.transfer("5KBWYsYudu9APDdUrHVPPDdyVMhjrRVq3zqDAEzhuogDR3caApb","machaoxiaoai", "machaoxiaoai","test12344444", "10.0000 SYS", "");
			System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println("============= 创建账户并且抵押 ===============");
		try {	
			Transaction t2 = rpc.createAccount("5KBWYsYudu9APDdUrHVPPDdyVMhjrRVq3zqDAEzhuogDR3caApb","machaoxiaoai","tokyohot1111", "EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV","EOS6MRyAjQq8ud7hVNYcfnVPJqcVpscN5So8BhtHuGYqET5GDW5CV", 8164l, "0.1000 EOS","0.1000 EOS", 0l);
			System.out.println("创建成功 = " + t2.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("============= 创建账户不抵押 ===============");
		try {	
			Transaction t3 = rpc.createAccount("5KBWYsYudu9APDdUrHVPPDdyVMhjrRVq3zqDAEzhuogDR3caApb","machaoxiaoai","raowenbo2eos", "EOS6wL4RgBszxsRVGoC6Fyyo56HM98N8yfeFQ37uRiH98Z6RbdkrX","EOS6wL4RgBszxsRVGoC6Fyyo56HM98N8yfeFQ37uRiH98Z6RbdkrX", 3072l);
			System.out.println("创建成功 = " + t3.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("============= 代理投票 ===============");
		try {
			List<String> produces = new ArrayList<>();
			produces.add("pppppeeeeooo");
			produces.add("mdddssssddds");
			produces.add("mdjddjddddds");
			rpc.voteproducer("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "epskdkdsddss","iuewjdkslsdc",produces);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("============= 关闭余额为0的token ===============");
		try {
			rpc.close("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "合约账户", "关闭账户", "0.0000 IPOS");
		}catch(ApiException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("\n******************* Rpc End *******************");
