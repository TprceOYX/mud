package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.Room;

public class RoomManagement {
	public static Map<String, Room> cityMap = new HashMap<String, Room>();

	public static void creatRooms() {
		/*����*/
		Room room_guangchang = new Room();	
		room_guangchang.setRoomId("yangzhou_guangchang");
		room_guangchang.SetRoomName("���ݹ㳡");
		room_guangchang.setDescription(" �����ǳ��е������ģ�һ���ܿ����Ĺ㳡��������ʯ���档һЩ���ֺ��е��������������������������������ݡ�����Կ������ߺ��ϱ��Ǽ��Ҵ�ĵ��̣�����ȫ�����ص����������������������������ر�Ӫ����������������Ѳ�����ŵ����ڡ��㳡������һ��������(tree)���Ե�ʮ�ֵĴ�׳�����ϵ���Ҷ(leaf)�ǳ�ï�ܣ��м�ֻ��֪����С�������д�����ȥ�������Ա���һ������������(sign)");
		
		//�����
		Room room_beidajie1 = new Room();
		room_beidajie1.setRoomId("yangzhou_beidajie1");
		room_beidajie1.SetRoomName("�����");
		room_beidajie1.setDescription("������һ����æ�Ľֵ��ϣ����Ų�����ǻ������������ɫ�Ҵң������˶����ϱ���ȥ������ͨ��һ�����ֵĹ㳡��������һ��������¡�ı�����ջ�����Ը��ص����ǽ�������������������һ�����ֺŵ�Ǯׯ����Ϊ���ի�������������������Ľ���������");
		
		Room room_beidajie2 = new Room();
		room_beidajie2.setRoomId("yangzhou_beidajie2");
		room_beidajie2.SetRoomName("�����");
		room_beidajie2.setDescription("������һ����æ�Ľֵ��ϣ�������������վ�����Ծ��ǵĿ�����ʱ�ἱʻ���룬Ƭ�̺��ֻ�����һƥ��������������������ȥ��������һ�Ҵ���̣���ǰ�����������д��һ������ġ������֣���ϸ��������������ѹ�͵��ּۻ��۵�������");
		
		Room room_beidajie3 = new Room();
		room_beidajie3.setRoomId("yangzhou_beidajie3");
		room_beidajie3.SetRoomName("�����");
		room_beidajie3.setDescription("����һ����������ʯ�ֵ������ϱ���ͷ���졣�����Ǳ�����ͨ����⡣�ϱ��Եúܷ�æ��������һ��С�Ե꣬����խС������ֻ��Ӧ���������߾��ǳ�������");
		
		Room room_beimen = new Room();
		room_beimen.setRoomId("yangzhou_beimen");
		room_beimen.SetRoomName("����");
		room_beimen.setDescription("���Ǿ������ݳǵı������ˣ����ſ�һ�Ӷӹٱ������̲�����İ��գ�һ���ֳֳ������������佫�����ſ�Ѳ�ӣ���Щʱ����Ϊ����һ���ķ�˽���������ң����Գ�͢�԰��²��������������˳�Ҫ���Ĺ�ְ���Ͼ���ն�ˣ�����һλ�µ�Ѳ�����ˣ�Ū���������Ļ̻̣�˭�������ڳ��ž��������ŵ�ǽ��������һֽ��ʾ(gaoshi)��");
		
		Room room_qianzhuang = new Room();
		room_qianzhuang.setRoomId("yangzhou_qianzhuang");
		room_qianzhuang.SetRoomName("���ի");
		room_qianzhuang.setDescription("����һ�����ֺŵ�Ǯׯ�����м��������ʷ����ȫ�����ض��зֵꡣ�����е���Ʊ�����ǳ��ã�ͨ��ȫ����");
		
		Room room_kezhan = new Room();
		room_kezhan.setRoomId("yangzhou_kezhan");
		room_kezhan.SetRoomName("������ջ");
		room_kezhan.setDescription("������������¡�ı�����ջ������������οͶ�ѡ���ڴ���š�һ������ĵ�С����������æ������ת���Ӵ�����ǻ�����Ŀ��ˡ���ջ�����ǽ�Ϲ���һ����Ŀ������(zhaopai)�������ǽ�Ϲ���һ�����Ϲ��ڵĸ�ʾ(gaoshi)��");
		
		Room room_yizhan = new Room();
		room_yizhan.setRoomId("yangzhou_yizhan");
		room_yizhan.SetRoomName("��վ");
		room_yizhan.setDescription("����������վ�������ͺ;�������������ġ�ÿ�������ƥ���������������������Ρ������������Ҫ�ĵ����ֻҪ�ŵ����һ��֮�ھ��Կ����͵���������һ���¿��Ļ��꣬��˵������ϰ�ǳ�Ư����");
		
		Room room_dangpu = new Room();
		room_dangpu.setRoomId("yangzhou_dangpu");
		room_dangpu.SetRoomName("����");
		room_dangpu.setDescription("����һ������������ƽ���Ƶ����ֺŵ��̣�һ���ĳ߸ߵĹ�̨���������ǰ����̨�ϰ���һ������(paizi)�� ��̨�����ŵ��̵��ϰ壬һ˫��������۾��������´�������.");
		
		Room room_chmiao = new Room();
		room_chmiao.setRoomId("yangzhou_chmiao");
		room_chmiao.SetRoomName("������");
		room_chmiao.setDescription(" �������ݳǱ��ĳ�����������ƽ�����ϡ�٣���������ڡ�����ڻ��������ʱ�򣬲Ż���Щ������з���һ��������������������˻ҳ���ǽ�����и���֩��������ֻ֩�����ĵض������档");
		
		Room room_xiaochidian = new Room();
		room_xiaochidian.setRoomId("yangzhou_xiaochidian");
		room_xiaochidian.SetRoomName("С�Ե�");
		room_xiaochidian.setDescription("����һ��С�꣬���⵹��ͦ��¡�ģ���λ���������ģ�����Щ����վ�ŵ������������Ҳ�����棬���������ӡ����ȡ���Ѽ���׾Ƹ�·�ɡ�");
		
		
		//�ϴ��
		Room room_nandajie1 = new Room();
		room_nandajie1.setRoomId("yangzhou_nandajie1");
		room_nandajie1.SetRoomName("�ϴ��");
		room_nandajie1.setDescription("�ϴ���������ݳ���ķ����ضΣ�һ�����ϣ�һ�ɵƺ���̣���Ϊ���֡�Ц�������������������������һƬ��������Ķ��䣬�㲻����Գ����������ʹ�ͣ������һ����������һ�����ֵĹ㳡��������һƬ�����������š�һ��һʮ������Ǯ����ԭ�������Ƿ�Բǧ��֮������һ�Ҷĳ�");
		
		Room room_nandajie2 = new Room();
		room_nandajie2.setRoomId("yangzhou_nandajie2");
		room_nandajie2.SetRoomName("�ϴ��");
		room_nandajie2.setDescription("������һ�������Ľֵ��ϣ����ϱ���ͷ���졣�ϱ��Ǽ���԰�֣�����ͨ�������ģ�������һ�ҹ˿��ڶ�Ĳ�ݣ����̾�����ʿ��������̸��˵�ء��������ǹٸ�����������ξ֡�");
		
		Room room_nandajie3 = new Room();
		room_nandajie3.setRoomId("yangzhou_nandajie3");
		room_nandajie3.SetRoomName("�ϴ��");
		room_nandajie3.setDescription("������һ�������Ľֵ��ϣ����ϱ���ͷ���졣�ϱ����ϳ��ţ�����ͨ�������ģ��������߸���һ��С԰��");
		
		Room room_nanmen = new Room();
		room_nanmen.setRoomId("yangzhou_nanmen");
		room_nanmen.SetRoomName("����");
		room_nanmen.setDescription("�������ݵ��ϳ��ţ���ǽ������һ�Źٸ��ĸ�ʾ(gaoshi)�������ǻ��εļ�ɢ�أ��������η��Ӻܶ࣬�����ٱ���������ؼ����������ˣ��鿴�����Ƿ�Я����˽�Ρ��ϱߵ���ʯ�������һֱͨ��Զ��������������ͷ��");
		
		Room room_duchang = new Room();
		room_duchang.setRoomId("yangzhou_duchang");
		room_duchang.SetRoomName("�ĳ�");
		room_duchang.setDescription("�����Ƕĳ��Ĵ��ã����ܵķ����ﴫ����ߺ������ĶĲ����������Ƕġ���С���ķ��䣬�����Ƕġ��ƾš��ķ��䣬¥�ϵĹ������ƻ�ͨ����");
		
		Room room_bingying = new Room();
		room_bingying.setRoomId("yangzhou_bingying");
		room_bingying.SetRoomName("��Ӫ");
		room_bingying.setDescription("�����Ǳ�Ӫ���������鵽�����ǹٱ����е����佫��ָ�����жӲ������еĶ������������е����š�����������Ϣ����ǽ��������˧��������ɫ��Ѱ�������ܡ����������������ȫ�������Χ�˹��������ƿ�����̫�������һ��С����(window)��Ϊ�˷���̽��İ��գ����Դ�������ڴ���(pass)Щ�ԵĶ�����");
		
		Room room_chaguan = new Room();
		room_chaguan.setRoomId("yangzhou_chaguan");
		room_chaguan.SetRoomName("���");
		room_chaguan.setDescription("�������ݳ��ϵ�һ�Ҳ�ݡ�һ�߽��������ŵ�һ�ɲ���������Ƣ����ľ���Ϊ֮һˬ�����Ű�����һ���ſ��������˿��ˣ������̸Ц����ͷ�Ӷ������Ϲ���һ������(zitie) ���������һ˵��֮�ˣ���������־��ˮ䰴�������Ӣ�Ҵ��ȵ�Ӣ�۹��¡��販ʿ����ߺ�����к�����, �ݲ���ˮ, æ�Ĳ����ֺ���");
		
		Room room_yanju = new Room();
		room_yanju.setRoomId("yangzhou_yanju");
		room_yanju.SetRoomName("�ξ�");
		room_yanju.setDescription("������һ���ṹ��ΰ�Ľ���ǰ������ʯ̳�ϸ�����һ�����ɶ�ߵ���ˣ����Ͻ���Ʈ�����������д�š������ξ֡��ĸ����֣������������˵��Ǹվ��Ƿ�������һ���ǽ������εļ�ɢ֮�أ��ٸ�Ϊ�˱��ڹ���, ������˰, �����������ξ�, ֱ�������ڳ�͢����ڴ���һ��������˵Ц��ǽ�Ƕ���һ��ʯ�ҷۣ��Ա߷��Ÿ�������");
		
		Room room_geyuan = new Room();
		room_geyuan.setRoomId("yangzhou_geyuan");
		room_geyuan.SetRoomName("��԰");
		room_geyuan.setDescription("�ݴ����������̻�Ӧ̩�޽���԰������ǧ�ˣ�����Ҷ���硰�����֣�������������԰����ת�������ȣ�ӭ�滨̳���������ʯ�񡣱���԰�����С���԰������ʯ�԰����Ϊ������ǰֲ����������ˮ�أ������ܼ�ʽСͤ��ˮ�������ӱ�ǽ�Ǻ�ʯ��ɽ��ɽ�Ϲ��ɣ�ɽ��������ˮ���������꣬ˮ�е�Ӱ��䣬����ɽ֮�ơ�");
		
		Room room_xiaopangu = new Room();
		room_xiaopangu.setRoomId("yangzhou_xiaopangu");
		room_xiaopangu.SetRoomName("С�̹�");
		room_xiaopangu.setDescription("С�̹�������һ��������СͥԺ��԰���Ժ�ʯ��ɽΪ����ɽ�����������ƶ����У�����һ�����ȣ���ͷ������ɽ�ȡ�ɽ���£�ˮ���ϣ���ռ�һʯ����ͨ��ˮ����ͤ��");
		
		
		//�����
		Room room_xidajie1 = new Room();
		room_xidajie1.setRoomId("yangzhou_xidajie1");
		room_xidajie1.SetRoomName("�����");
		room_xidajie1.setDescription("����һ����������ʯ��ֵ���������ͷ���졣������һƬ��ɫ��¥������Լ�����������Ц���Ǿ����������������񷻡���������������һ�����ֵĹ㳡��");
		
		Room room_xidajie2 = new Room();
		room_xidajie2.setRoomId("yangzhou_xidajie2");
		room_xidajie2.SetRoomName("�����");
		room_xidajie2.setDescription("����һ����������ʯ��ֵ���������ͷ���졣�����������������������Ҽ������ַǳ����Ӷ��治ʱ�ش���Ц��ݺ�裬�������ˣ�������������һ������������ϱ������������ݴ����£����߾������������ˡ�");
		
		Room room_xidajie3 = new Room();
		room_xidajie3.setRoomId("yangzhou_xidajie3");
		room_xidajie3.SetRoomName("�����");
		room_xidajie3.setDescription("������������ϣ��е�����Ľ���Ҫ�ȱ𴦵ĸɾ������ࡣ���ϵ����˱���ǰҲ�������࣬���������ݵ������羰�����������������������š��ϱ���һ���Ѿ������˵��鱦�꣬����������һ���Ѿ������˵Ĵ��¥������һ���������Ŷ�������һ�����ң��ڰ�֮�п���̫�����ϵ��ּ���");
		
		Room room_ximen = new Room();
		room_ximen.setRoomId("yangzhou_ximen");
		room_ximen.SetRoomName("����");
		room_ximen.setDescription("���������ţ���ǽ�����ż���ͨ����ʾ(gaoshi)��������������ıؾ�֮�أ��ٱ��ǽ䱸ɭ�ϡ�һ����ֱ����ʯ���������������졣�����ǽ��⣬�����ġ����εġ���·�ģ����˴Ҵҡ������ǳ��������֡�");
		
		Room room_mingyufang=new Room();
		room_mingyufang.setRoomId("yangzhou_mingyufang");
		room_mingyufang.SetRoomName("����");
		room_mingyufang.setDescription("���������񷻣�û������!");
		
		Room room_shouxihu=new Room();
		room_shouxihu.setRoomId("yangzhou_shouxihu");
		room_shouxihu.SetRoomName("������");
		room_shouxihu.setDescription("��������������û��������");
		
		Room room_damingsi=new Room();
		room_damingsi.setRoomId("yangzhou_damingsi");
		room_damingsi.SetRoomName("������");
		room_damingsi.setDescription("�����Ǵ����£�û��������");
		
		Room room_jiulou=new Room();
		room_jiulou.setRoomId("yangzhou_jiulou");
		room_jiulou.SetRoomName("���¥");
		room_jiulou.setDescription("�����Ǵ��¥��û��������");
		
		Room room_zhubaodian=new Room();
		room_zhubaodian.setRoomId("yangzhou_zhubaodian");
		room_zhubaodian.SetRoomName("�鱦��");
		room_zhubaodian.setDescription("�������鱦�꣬û��������");
		
		
		//�����
		Room room_dongdajie1 = new Room();
		room_dongdajie1.setRoomId("yangzhou_dongdajie1");
		room_dongdajie1.SetRoomName("�����");
		room_dongdajie1.setDescription(" ����һ����������ʯ��ֵ���������ͷ���졣���߲�ʱ�ش������ʵ�������������һ�����ֵĹ㳡���ϱ�����һ�ҹ����ɫ�ĵ��̣���߲�ʱ���������������������");
		
		Room room_dongdajie2 = new Room();
		room_dongdajie2.setRoomId("yangzhou_dongdajie2");
		room_dongdajie2.SetRoomName("�����");
		room_dongdajie2.setDescription("����һ����������ʯ��ֵ���������ͷ���졣���߲�ʱ�ش�������ײ�����������������ӡ�������һ�����ӵ�Ժ�ӣ������εĴ����Ϸ�д�š���¹��Ժ���ĸ��̽���֣��Ծ����������治ʱ�ش���ѧ��������ٴ�Ķ��������ϱ���һ���ӻ��̡�");
		
		Room room_dongdajie3 = new Room();
		room_dongdajie3.setRoomId("yangzhou_dongdajie3");
		room_dongdajie3.SetRoomName("�����");
		room_dongdajie3.setDescription("�����ڶ�����ϣ����ż�ʵ����ʯ����档�����Ǵ����̺������꣬��ʱ�������ô��Ľ���ײ���������������ʵĶ�����������һ�𡣱�����һ�����ֺŵ�ҩ�̣��ϱ��ǼҼ����ꡣ");
		
		Room room_dongmen = new Room();
		room_dongmen.setRoomId("yangzhou_dongmen");
		room_dongmen.SetRoomName("����");
		room_dongmen.setDescription("���������ݶ����ţ��������Ϸ����š����š�����������֣���ǽ�����ż��Źٸ��ĸ�ʾ(gaoshi)���ٱ��Ǿ����ע���Ź������ˣ�ͨ�������С��Ϊ�һ����ֱ����ʯ���������������졣�����ǽ��⣬��Լ�ɼ�һƬһ���޼ʵ����֣�����Ī�⡣");
		
		Room room_yueqidian=new Room();
		room_yueqidian.setRoomId("yangzhou_yueqidian");
		room_yueqidian.SetRoomName("������");
		room_yueqidian.setDescription("�����������꣬û��������");
		
		Room room_shuyuan=new Room();
		room_shuyuan.setRoomId("yangzhou_shuyuan");
		room_shuyuan.SetRoomName("��¹��Ժ");
		room_shuyuan.setDescription("�����ǰ�¹��Ժ��û��������");
		
		Room room_zahuopu=new Room();
		room_zahuopu.setRoomId("yangzhou_zahuopu");
		room_zahuopu.SetRoomName("�ӻ���");
		room_zahuopu.setDescription("�����ǽ����ӻ��̣�û��������");
		
		Room room_yaopu=new Room();
		room_yaopu.setRoomId("yangzhou_yaopu");
		room_yaopu.SetRoomName("ҩ��");
		room_yaopu.setDescription("������ҩ�̣�û��������");
		
		Room room_jimaidian=new Room();
		room_jimaidian.setRoomId("yangzhou_jimaidian");
		room_jimaidian.SetRoomName("������");
		room_jimaidian.setDescription("�����Ǽ����꣬û��������");
		
		Room room_datiepu=new Room();
		room_datiepu.setRoomId("yangzhou_datiepu");
		room_datiepu.SetRoomName("������");
		room_datiepu.setDescription("�����Ǵ����̣�û��������");
		
		Room room_wuqidian=new Room();
		room_wuqidian.setRoomId("yangzhou_wuqidian");
		room_wuqidian.SetRoomName("������");
		room_wuqidian.setDescription("�����������꣬û��������");
		//��������������
		//�㳡
		room_guangchang.setRoom(CommonContent.DIRECTION.NORTH, room_beidajie1);
		room_guangchang.setRoom(CommonContent.DIRECTION.SOUTH, room_nandajie1);
		room_guangchang.setRoom(CommonContent.DIRECTION.EAST, room_dongdajie1);
		room_guangchang.setRoom(CommonContent.DIRECTION.WEST, room_xidajie1);
		//�����
		room_beidajie1.setRoom(CommonContent.DIRECTION.NORTH, room_beidajie2);
		room_beidajie1.setRoom(CommonContent.DIRECTION.SOUTH, room_guangchang);
		room_beidajie1.setRoom(CommonContent.DIRECTION.EAST, room_kezhan);
		room_beidajie1.setRoom(CommonContent.DIRECTION.WEST, room_qianzhuang);
		
		room_beidajie2.setRoom(CommonContent.DIRECTION.NORTH, room_beidajie3);
		room_beidajie2.setRoom(CommonContent.DIRECTION.SOUTH, room_beidajie1);
		room_beidajie2.setRoom(CommonContent.DIRECTION.EAST, room_yizhan);
		room_beidajie2.setRoom(CommonContent.DIRECTION.WEST, room_dangpu);
		
		room_beidajie3.setRoom(CommonContent.DIRECTION.NORTH, room_beimen);
		room_beidajie3.setRoom(CommonContent.DIRECTION.SOUTH, room_beidajie2);
		room_beidajie3.setRoom(CommonContent.DIRECTION.EAST, room_xiaochidian);
		room_beidajie3.setRoom(CommonContent.DIRECTION.WEST, room_chmiao);
		
		room_beimen.setRoom(CommonContent.DIRECTION.SOUTH, room_beidajie3);
		room_qianzhuang.setRoom(CommonContent.DIRECTION.EAST, room_beidajie1);
		room_kezhan.setRoom(CommonContent.DIRECTION.WEST, room_beidajie1);
		room_dangpu.setRoom(CommonContent.DIRECTION.EAST, room_beidajie2);
		room_yizhan.setRoom(CommonContent.DIRECTION.WEST, room_beidajie2);
		room_chmiao.setRoom(CommonContent.DIRECTION.EAST, room_beidajie3);
		room_xiaochidian.setRoom(CommonContent.DIRECTION.WEST, room_beidajie3);
		
		//�ϴ��
		room_nandajie1.setRoom(CommonContent.DIRECTION.NORTH, room_guangchang);
		room_nandajie1.setRoom(CommonContent.DIRECTION.SOUTH, room_nandajie2);
		room_nandajie1.setRoom(CommonContent.DIRECTION.WEST, room_duchang);
		room_nandajie1.setRoom(CommonContent.DIRECTION.EAST, room_bingying);
		
		room_nandajie2.setRoom(CommonContent.DIRECTION.NORTH, room_nandajie1);
		room_nandajie2.setRoom(CommonContent.DIRECTION.SOUTH, room_nandajie3);
		room_nandajie2.setRoom(CommonContent.DIRECTION.WEST, room_chaguan);
		room_nandajie2.setRoom(CommonContent.DIRECTION.EAST, room_yanju);
		
		room_nandajie3.setRoom(CommonContent.DIRECTION.NORTH, room_nandajie2);
		room_nandajie3.setRoom(CommonContent.DIRECTION.SOUTH, room_nanmen);
		room_nandajie3.setRoom(CommonContent.DIRECTION.WEST, room_geyuan);
		room_nandajie3.setRoom(CommonContent.DIRECTION.EAST, room_xiaopangu);
		
		room_nanmen.setRoom(CommonContent.DIRECTION.NORTH, room_nandajie3);
		room_duchang.setRoom(CommonContent.DIRECTION.EAST, room_nandajie1);
		room_bingying.setRoom(CommonContent.DIRECTION.WEST, room_nandajie1);
		room_chaguan.setRoom(CommonContent.DIRECTION.EAST, room_nandajie2);
		room_yanju.setRoom(CommonContent.DIRECTION.WEST, room_nandajie2);
		room_geyuan.setRoom(CommonContent.DIRECTION.EAST, room_nandajie3);
		room_xiaopangu.setRoom(CommonContent.DIRECTION.WEST, room_nandajie3);
		
		//�����
		room_xidajie1.setRoom(CommonContent.DIRECTION.NORTH, room_mingyufang);
		room_xidajie1.setRoom(CommonContent.DIRECTION.WEST, room_xidajie2);
		room_xidajie1.setRoom(CommonContent.DIRECTION.EAST, room_guangchang);
		
		room_xidajie2.setRoom(CommonContent.DIRECTION.NORTH, room_shouxihu);
		room_xidajie2.setRoom(CommonContent.DIRECTION.SOUTH, room_damingsi);
		room_xidajie2.setRoom(CommonContent.DIRECTION.WEST, room_xidajie3);
		room_xidajie2.setRoom(CommonContent.DIRECTION.EAST, room_xidajie1);
		
		room_xidajie3.setRoom(CommonContent.DIRECTION.NORTH, room_jiulou);
		room_xidajie3.setRoom(CommonContent.DIRECTION.SOUTH, room_zhubaodian);
		room_xidajie3.setRoom(CommonContent.DIRECTION.WEST, room_ximen);
		room_xidajie3.setRoom(CommonContent.DIRECTION.EAST, room_xidajie2);
		
		room_ximen.setRoom(CommonContent.DIRECTION.EAST, room_xidajie3);
		room_jiulou.setRoom(CommonContent.DIRECTION.SOUTH, room_xidajie3);
		room_zhubaodian.setRoom(CommonContent.DIRECTION.NORTH, room_xidajie3);
		room_shouxihu.setRoom(CommonContent.DIRECTION.SOUTH, room_xidajie2);
		room_damingsi.setRoom(CommonContent.DIRECTION.NORTH, room_xidajie2);
		room_mingyufang.setRoom(CommonContent.DIRECTION.SOUTH, room_xidajie1);
		
		//�����
		room_dongdajie1.setRoom(CommonContent.DIRECTION.SOUTH, room_yueqidian);
		room_dongdajie1.setRoom(CommonContent.DIRECTION.WEST, room_guangchang);
		room_dongdajie1.setRoom(CommonContent.DIRECTION.EAST, room_dongdajie2);
		
		room_dongdajie2.setRoom(CommonContent.DIRECTION.NORTH, room_shuyuan);
		room_dongdajie2.setRoom(CommonContent.DIRECTION.SOUTH, room_zahuopu);
		room_dongdajie2.setRoom(CommonContent.DIRECTION.WEST, room_dongdajie1);
		room_dongdajie2.setRoom(CommonContent.DIRECTION.EAST, room_dongdajie3);
		
		room_dongdajie3.setRoom(CommonContent.DIRECTION.NORTH, room_yaopu);
		room_dongdajie3.setRoom(CommonContent.DIRECTION.SOUTH, room_jimaidian);
		room_dongdajie3.setRoom(CommonContent.DIRECTION.WEST, room_dongdajie2);
		room_dongdajie3.setRoom(CommonContent.DIRECTION.EAST, room_dongmen);
		
		room_dongmen.setRoom(CommonContent.DIRECTION.NORTH, room_datiepu);
		room_dongmen.setRoom(CommonContent.DIRECTION.SOUTH, room_wuqidian);
		room_dongmen.setRoom(CommonContent.DIRECTION.WEST, room_dongdajie3);
		
		room_yueqidian.setRoom(CommonContent.DIRECTION.NORTH, room_dongdajie1);
		room_shuyuan.setRoom(CommonContent.DIRECTION.SOUTH, room_dongdajie2);
		room_zahuopu.setRoom(CommonContent.DIRECTION.NORTH, room_dongdajie2);
		room_yaopu.setRoom(CommonContent.DIRECTION.SOUTH, room_dongdajie3);
		room_jimaidian.setRoom(CommonContent.DIRECTION.NORTH, room_dongdajie3);
		room_datiepu.setRoom(CommonContent.DIRECTION.SOUTH, room_dongmen);
		room_wuqidian.setRoom(CommonContent.DIRECTION.NORTH, room_dongmen);
		//����������ͼ��
		//�㳡
		cityMap.put(room_guangchang.getRoomId(), room_guangchang);
		//����
		cityMap.put(room_beidajie1.getRoomId(), room_beidajie1);
		cityMap.put(room_beidajie2.getRoomId(), room_beidajie2);
		cityMap.put(room_beidajie3.getRoomId(), room_beidajie3);
		cityMap.put(room_beimen.getRoomId(), room_beimen);
		cityMap.put(room_qianzhuang.getRoomId(), room_qianzhuang);
		cityMap.put(room_kezhan.getRoomId(), room_kezhan);
		cityMap.put(room_dangpu.getRoomId(), room_dangpu);
		cityMap.put(room_yizhan.getRoomId(), room_yizhan);
		cityMap.put(room_chmiao.getRoomId(), room_chmiao);
		cityMap.put(room_xiaochidian.getRoomId(), room_xiaochidian);
		//�ϱ�
		cityMap.put(room_nandajie1.getRoomId(), room_nandajie1);
		cityMap.put(room_nandajie2.getRoomId(), room_nandajie2);
		cityMap.put(room_nandajie3.getRoomId(), room_nandajie3);
		cityMap.put(room_nanmen.getRoomId(), room_nanmen);
		cityMap.put(room_duchang.getRoomId(), room_duchang);
		cityMap.put(room_bingying.getRoomId(), room_bingying);
		cityMap.put(room_chaguan.getRoomId(), room_chaguan);
		cityMap.put(room_yanju.getRoomId(), room_yanju);
		cityMap.put(room_geyuan.getRoomId(), room_geyuan);
		cityMap.put(room_xiaopangu.getRoomId(), room_xiaopangu);
		//����
		cityMap.put(room_xidajie1.getRoomId(),room_xidajie1);
		cityMap.put(room_xidajie2.getRoomId(),room_xidajie2);
		cityMap.put(room_xidajie3.getRoomId(),room_xidajie3);
		cityMap.put(room_ximen.getRoomId(),room_ximen);
		cityMap.put(room_mingyufang.getRoomId(),room_mingyufang);
		cityMap.put(room_shouxihu.getRoomId(),room_shouxihu);
		cityMap.put(room_damingsi.getRoomId(),room_damingsi);
		cityMap.put(room_jiulou.getRoomId(),room_jiulou);
		cityMap.put(room_zhubaodian.getRoomId(),room_zhubaodian);
		//����
		cityMap.put(room_dongdajie1.getRoomId(),room_dongdajie1);
		cityMap.put(room_dongdajie2.getRoomId(),room_dongdajie2);
		cityMap.put(room_dongdajie3.getRoomId(),room_dongdajie3);
		cityMap.put(room_dongmen.getRoomId(),room_dongmen);
		cityMap.put(room_yueqidian.getRoomId(),room_yueqidian);
		cityMap.put(room_shuyuan.getRoomId(),room_shuyuan);
		cityMap.put(room_zahuopu.getRoomId(),room_zahuopu);
		cityMap.put(room_yaopu.getRoomId(),room_yaopu);
		cityMap.put(room_jimaidian.getRoomId(),room_jimaidian);
		cityMap.put(room_datiepu.getRoomId(),room_datiepu);
		cityMap.put(room_wuqidian.getRoomId(),room_wuqidian);
	}
}
