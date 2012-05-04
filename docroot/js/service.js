Liferay.Service.register("Liferay.Service.Onddo", "net.sareweb.onddo.service", "Onddo-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Onddo, "Picking",
	{
		getPickingById: true,
		addPicking: true,
		updatePicking: true,
		deletePickingById: true,
		findByUserId: true
	}
);