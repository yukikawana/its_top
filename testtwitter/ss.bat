@rem �����̏ꏊ���w��
@set WAVPATH=C:\pleiades-e4.4-java-jre_20140926\pleiades\workspace\its_top\testtwitter\mysound.mp3

@rem �Đ����Ԓ����~���b�Ŏw��
@set HTA_MAX_TIME=3000

@rem �Đ����s
@mshta "about:playing... <OBJECT CLASSID='CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95' WIDTH=100 HEIGHT=100><param name='src' value='%WAVPATH%'><param name='PlayCount' value='1'><param name='autostart' value='true'></OBJECT><script>window.resizeTo(10,10);window.moveTo(700,700);setTimeout(function(){window.close()},%HTA_MAX_TIME%);</script>"