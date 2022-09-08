function guest_modify_form_content(){
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
										방명록 수정</b></td>
							</tr>
						</tbody>
					</table> <!-- modify Form  -->
					<form name="f" method="post" id="f">
						<input type="hidden" name="guest_no" value="${guest.guest_no}">
						<table border="0" cellpadding="0" cellspacing="1" width="590"
							bgcolor="BBBBBB">
							<tbody>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px">${guest.guest_no}</td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px"><input type="text"
										style="width: 150" name="guest_name" value="${guest.guest_name}"></td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px"><input type="text"
										style="width: 150" name="guest_homepage" value="${guest.guest_homepage}"></td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px"><input type="text"
										style="width: 240" name="guest_email" value="${guest.guest_email}"></td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px"><input type="text"
										style="width: 240" name="guest_title" value="${guest.guest_title}"></td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
									<td align="left" width="490" bgcolor="ffffff"
										style="padding-left: 10px"><textarea wrap="soft"
											style="width: 240px" rows="10" name="guest_content">${guest.guest_content}</textarea>
	
									</td>
								</tr>
							</tbody>
						</table>
					</form>
	
					<table width="590" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td align="center"><input type="button" value="수정" id="guest_modify_action_btn"> &nbsp; 
								<input id="guest_list_btn" type="button" value="목록"></td>
							</tr>
						</tbody>
					</table></td>
			</tr>
		</tbody>
	</table>`;
}