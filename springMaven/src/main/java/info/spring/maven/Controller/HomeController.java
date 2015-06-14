package info.spring.maven.Controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import info.spring.maven.Model.Users;
import info.spring.maven.Service.CaptchasDotNet;
import info.spring.maven.Service.UserService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Returns the list of users
	 * 
	 * @param The
	 *            model coming from client
	 * @return The name of home page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getUserLists(Model model) {
		try {
			model.addAttribute("userlist", userService.listUser());
		} catch (Exception ex) {
			logger.error("--- error: " + ex);
		}
		return "home";
	}

	/**
	 * Adds a new user to the list
	 * 
	 * @param request
	 *            The request coming from client
	 * @return A string includes html data
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody String addUser(HttpServletRequest request) {
		String html = "";
		try {
			// Read the form values
			String password = request.getParameter("captcha");
			Users user = new Users(request.getParameter("name"),
					request.getParameter("surname"),
					request.getParameter("telephone"));

			CaptchasDotNet captchas = new CaptchasDotNet(
					request.getSession(true), // Ensure session
					"demo", // client
					"secret" // secret
			);
			char captchasCheck = captchas.check(password);

			// Backend validation controls
			if (user.getName() == null
					|| user.getName().equals("")
					|| user.getSurname() == null
					|| user.getSurname().equals("")
					|| user.getPhone() == null
					|| (user.getPhone().length() != 15 && user.getPhone()
							.length() != 0) || captchasCheck == 's'
					|| captchasCheck == 'm' || captchasCheck == 'w') {
				return html;
			}
			Users addedUser = userService.addUser(user);

			html = "<tr id = userTable"
					+ addedUser.getId()
					+ ">"
					+ "<td>"
					+ addedUser.getName()
					+ "</td>"
					+ "<td>"
					+ addedUser.getSurname()
					+ "</td>"
					+ "<td>"
					+ addedUser.getPhone()
					+ "</td>"
					+ "<td>"
					+ "<input type=\"submit\" class=\"btn btn-danger\" name=\"deleteButton\" value=\"Delete\" onclick=\"deleteConfirm('"
					+ addedUser.getId()
					+ "');\"/>"
					+ "<input type=\"submit\" class=\"btn btn-success\" name=\"updateButton\" value=\"Update\" onclick=\"updateConfirm('"
					+ addedUser.getId() + "','" + addedUser.getName() + "','"
					+ addedUser.getSurname() + "','" + addedUser.getPhone()
					+ "');\"/>" + "</td>" + "</tr>";
		} catch (Exception ex) {
			logger.error("error:" + ex);
			return null;
		}
		return html;
	}

	/**
	 * Deletes the user with given identity
	 * @param request The request coming from client
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody void deleteUser(HttpServletRequest request) {
		try {
			userService.deleteUser(request.getParameter("id"));
		} catch (Exception ex) {
			logger.error("error:" + ex);
		}
	}

	/**
	 * Updates the user with given identity
	 * @param request The request coming from client
	 * @return A string includes html data
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody String updateUser(HttpServletRequest request) {
		String html = null;
		try {
			// Read the form values
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String phone = request.getParameter("telephone");

			// Backend validation controls
			if (id == null || id.equals("") || name == null || name.equals("")
					|| surname == null || surname.equals("") || phone == null
					|| (phone.length() != 15 && phone.length() != 0))
				return html;
			userService.updateUser(id, name, surname, phone);

			html = "<tr id = userTable"
					+ id
					+ ">"
					+ "<td>"
					+ name
					+ "</td>"
					+ "<td>"
					+ surname
					+ "</td>"
					+ "<td>"
					+ phone
					+ "</td>"
					+ "<td>"
					+ "<input type=\"submit\" class=\"btn btn-danger\" name=\"deleteButton\" value=\"Delete\" onclick=\"deleteConfirm('"
					+ id
					+ "');\"/>"
					+ "<input type=\"submit\" class=\"btn btn-success\" name=\"updateButton\" value=\"Update\" onclick=\"updateConfirm('"
					+ id + "','" + name + "','" + surname + "','" + phone
					+ "');\"/>" + "</td>" + "</tr>";

		} catch (Exception ex) {
			logger.error("error:" + ex);
		}
		return html;
	}
}
