function guest_list_content(html){
	return `<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td><br>
				<table style="padding-left: 10px" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
									리스트</b></td>
						</tr>
					</tbody>
				</table>
				<form name="f" method="post">

					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tbody>
							<tr>
								<td width="50" align="center" bgcolor="E6ECDE" height="22">번호</td>
								<td width="300" align="center" bgcolor="E6ECDE">제목</td>
								<td width="120" align="center" bgcolor="E6ECDE">이름</td>
								<td width="120" align="center" bgcolor="E6ECDE">날짜</td>
							</tr>
							
							<!-- guest start -->
								${html}
							<!-- guest end -->
						
						</tbody>
					</table>
				</form> <!-- button -->
				<table border="0" cellpadding="0" cellspacing="1" width="590">
					<tbody>
						<tr>
							<td align="right"><input type="button" id="btn_guest_write_form" value="방명록 쓰기"></td>
						</tr>
					</tbody>
				</table></td>
		</tr>
	</tbody>
</table>`;
}

function guest_main_content(){
			//template literal -> javaScript변수값을 넣을 수 있음.
	return `<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
			width="540px" height="350px">
			<param name="movie" value="image/FI_main.swf">
			<param name="play" value="true">
			<param name="loop" value="true">
			<param name="quality" value="high">
			<embed src="image/enter.png" scale="exactfit" play="true" loop="true"
				quality="high" style="margin: 10px;"
				pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
				width="540px" height="350px"></embed>
			</object>`;
}
function guest_modify_form_content(){
	return `
		`;
}
function guest_view_content(guest) {
	return `
			`;
}		
function guest_write_form_content() {
	return  `<table width="0" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<!--contents--> <br>
						<table style="padding-left: 10px" border="0" cellpadding="0"
							cellspacing="0">
							<tbody>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
											방명록 쓰기</b></td>
								</tr>
							</tbody>
						</table> <!-- guest write Form  -->
						<form id="guest_write_form" name="f" method="post">
							<table border="0" cellpadding="0" cellspacing="1" width="590"
								bgcolor="BBBBBB">
								<tbody>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
										<td width="490" align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_name"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일</td>
										<td width="490" align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_email"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
										<td width="490" align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_homepage"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">타이틀</td>
										<td width="490" align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 240" name="guest_title"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
										<td width="490" align="left" bgcolor="ffffff"
											style="padding-left: 10px"><textarea wrap="soft"
												style="width: 240px" rows="10" name="guest_content"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</form> <br>
						<table width="590" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td align="center"><input type="button" value="방명록쓰기" id="btn_guest_write_action"> &nbsp; 
									<input type="button" id="btn_guest_list_btn" value="방명록목록"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>`;
}	