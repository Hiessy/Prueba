package com.web.generic.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * Email
 * ^			#start of the line
 [_A-Za-z0-9-\\+]+	#  must start with string in the bracket [ ], must contains one or more (+)
 (			#   start of group #1
 \\.[_A-Za-z0-9-]+	#     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
 )*			#   end of group #1, this group is optional (*)
 @			#     must contains a "@" symbol
 [A-Za-z0-9-]+      #       follow by string in the bracket [ ], must contains one or more (+)
 (			#         start of group #2 - first level TLD checking
 \\.[A-Za-z0-9]+  #           follow by a dot "." and string in the bracket [ ], must contains one or more (+)
 )*		#         end of group #2, this group is optional (*)
 (			#         start of group #3 - second level TLD checking
 \\.[A-Za-z]{2,}  #           follow by a dot "." and string in the bracket [ ], with minimum length of 2
 )			#         end of group #3
 $			
 
 
 PASSWORD
 * (			# Start of group
  (?=.*\d)		#   must contains one digit from 0-9
  (?=.*[a-z])		#   must contains one lowercase characters
  (?=.*[A-Z])		#   must contains one uppercase characters
  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
              .		#     match anything with previous condition checking
                {6,20}	#        length at least 6 characters and maximum of 20
)			# End of group
 */
public class Validator {
	private Pattern patternEmail;
	private Pattern patternPassword;
	private Matcher matcher;
	
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Validator() {
		patternEmail = Pattern.compile(EMAIL_PATTERN);
		patternPassword = Pattern.compile(PASSWORD_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validateEmail(final String hex) {
		matcher = patternEmail.matcher(hex);
		return matcher.matches();

	}

	public boolean validatePassword(final String hex) {
		matcher = patternPassword.matcher(hex);
		return matcher.matches();

	}
}
