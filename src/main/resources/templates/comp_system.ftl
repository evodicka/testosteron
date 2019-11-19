<div class="card">
	<header class="card-header has-background-primary">
		<p class="card-header-title">System</p>
	</header>
	<div class="card-content">
		<div class="content">
			<h3 class="subtitle">Mem (free -m)</h3>
			<pre>${systemInfo.mem!}</pre>

			<h3 class="subtitle">Disk (df -h)</h3>
			<pre>${systemInfo.disks!}</pre>

			<h3 class="subtitle">Networks</h3>
			<pre>${systemInfo.nets!}</pre>
		</div>
	</div>
</div>
	  