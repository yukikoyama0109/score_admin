package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//フィルターを適用するURLの範囲を指定
// * は任意の文字列　＝＞　すべてのURLに対して適用
@WebFilter(urlPatterns = { "/*" })
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 共通の前処理を記述
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// System.out.println("エンコーディングフィルターの前処理");

		// 次のフィルター、またはサーブレットの処理を呼び出す
		chain.doFilter(request, response);

		// 共通の後処理を記述
		// System.out.println("エンコーディングフィルターの後処理");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
