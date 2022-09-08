function guest_list_content(html){
	return `
				 <table border="0" cellpadding="0" cellspacing="0">
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
										<td align="right"><input type="button" value="방명록 쓰기" id="guest_write_form_btn"></td>
									</tr>
								</tbody>
							</table></td>
					</tr>
				</tbody>
			</table>`;
}