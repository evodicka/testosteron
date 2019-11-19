<div class="card">
	<header class="card-header has-background-success">
		<p class="card-header-title">App</p>
	</header>
	<div class="card-content">
		<div class="content">
			<table class="table is-striped is-fullwidth is-narrow">
				<thead><tr><th colspan="2">Basics</th></tr></thead>
				<tbody>
					<#list appInfo.basics as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>
			
			<table class="table is-striped is-fullwidth is-narrow">
				<thead><tr><th colspan="2">CPU - Mem</th></tr></thead>
				<tbody>
					<#list appInfo.mems as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>			
			
			<form method="post" action="/action/shutdown">
				<input type="submit" value="Shutdown" class="button is-danger">
			</form>
		</div>
	</div>
</div>
	  