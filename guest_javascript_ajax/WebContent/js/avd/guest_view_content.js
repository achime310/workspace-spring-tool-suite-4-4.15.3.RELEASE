function guest_view_content(guest) {
	return `
			<table border="0" cellpadding="0" cellspacing="0">
					<tbody><tr>
						<td>
							<!--contents--> <br>
							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="0">
								<tbody><tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리
											- 방명록 상세보기</b></td>
								</tr>
							</tbody></table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="guest_no" value="${guest.guest_no}">
								<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
								<tbody><tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_no}</td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_name}</td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">날짜</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_date}</td>
								</tr><tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_homepage}</td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_title}</td>
								</tr>
								<tr>
									<td width="100" align="center" bgcolor="E6ECDE" height="110">내용</td>
									<td width="490" bgcolor="ffffff" align="left" style="padding-left: 10px">${guest.guest_content}</td>
								</tr>
								</tbody>
								</table>
							</form> <br>
							<table width="590" border="0" cellpadding="0" cellspacing="0">
								<tbody><tr>
									<td align="center">
										<input type="button" value="수정" id="guest_modify_form_btn" guest_no="${guest.guest_no}"> &nbsp; 
										<input type="button" value="삭제" id="guest_remove_action_btn" guest_no="${guest.guest_no}"> &nbsp; 
										<input type="button" value="목록" id="guest_list_btn">
									</td>
								</tr>
							</tbody></table>
						</td>
					</tr>
				</tbody></table>`;
}			